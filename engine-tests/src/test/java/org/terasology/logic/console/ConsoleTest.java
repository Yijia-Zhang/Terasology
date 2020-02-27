/*
 * Copyright 2016 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.logic.console;


import com.google.common.base.Preconditions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.platform.commons.PreconditionViolationException;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.terasology.TerasologyTestingEnvironment;
import org.terasology.entitySystem.entity.EntityManager;
import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.entitySystem.entity.internal.EngineEntityManager;
import org.terasology.logic.console.commandSystem.ConsoleCommand;
import org.terasology.logic.permission.PermissionCommands;
import org.terasology.logic.permission.PermissionManager;
import org.terasology.logic.permission.PermissionSetComponent;
import org.terasology.logic.permission. PermissionSystem;
import org.terasology.network.Client;
import org.terasology.network.ClientComponent;
import org.terasology.utilities.collection.CircularBuffer;

import java.rmi.server.ExportException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConsoleTest extends TerasologyTestingEnvironment {

    private final String MESSAGE_TEXT = "Test message";
    private EngineEntityManager entityManager;
    private EntityRef character;
    private EntityRef character2;
    private static final String PLAYER_ID = "fakeplayerID";

    private ConsoleImpl console = new ConsoleImpl(context);

    @Test
    public void testClearCommand() {
        for (int i = 0; i < 10; i++) {
            getConsole().addMessage("Just a message");
        }

        getConsole().clear();

        Iterator<Message> it = getConsole().getMessages().iterator();
        assertFalse(it.hasNext());
    }

    @Test
    public void testAddMessage() {
        getConsole().addMessage(MESSAGE_TEXT);

        checkMessage(getConsole().getMessages().iterator(), true);
    }

    @Test
    public void testAddConsoleMessage() {
        getConsole().addMessage(new Message(MESSAGE_TEXT));

        checkMessage(getConsole().getMessages().iterator(), true);
    }

    @Test
    public void testAddInlineMessage() {
        getConsole().addMessage(MESSAGE_TEXT, false);

        checkMessage(getConsole().getMessages().iterator(), false);
    }

    @Test
    public void testAddInlineMessage2() {
        getConsole().addMessage(new Message(MESSAGE_TEXT, false));

        checkMessage(getConsole().getMessages().iterator(), false);
    }

    private void checkMessage(Iterator<Message> it, boolean hasNewLine) {
        assertNotNull(it);
        assertTrue(it.hasNext());
        final Message message = it.next();
        assertEquals(MESSAGE_TEXT, message.getMessage());
        assertEquals(hasNewLine, message.hasNewLine());
        assertFalse(it.hasNext());
    }

    /************************************************************************************************
     * New tests
     *************************************************************************************************/

    private void checkMessage(Iterator<Message> it, boolean hasNewLine, String msg) {
        assertNotNull(it);
        assertTrue(it.hasNext());
        final Message message = it.next();
        assertEquals(msg, message.getMessage());
        assertEquals(hasNewLine, message.hasNewLine());
        assertFalse(it.hasNext());
    }
    @Test
    public void testDispose(){
        Message test1 = new Message("test message 1");
        Message test2 = new Message("test message 2");
        getConsole().addMessage(test1);
        getConsole().addMessage(test2);
        getConsole().dispose();
        assertFalse(getConsole().getMessages().iterator().hasNext());
    }

    @Test
    public void testRemoveMsg(){
        Message test1 = new Message("test message 1");
        Message test2 = new Message("test message 2");
        getConsole().addMessage(test1);
        getConsole().addMessage(test2);
        getConsole().removeMessage(test1);
        assertEquals("test message 2", getConsole().getMessages().iterator().next().getMessage());

        Message test3 = new Message("test message 3", CoreMessageType.CONSOLE);
        Message test4 = new Message("test message 4");


        getConsole().addMessage(test3);
        getConsole().addMessage(test4);


        getConsole().removeMessage(test3);
        getConsole().removeMessage(test4);
        Iterator<Message> itr = getConsole().getMessages().iterator();
        assertEquals(test2, itr.next());
        checkMessage(getConsole().getMessages().iterator(),true, "test message 2");
    }

    @Test
    public void testReplaceMsg(){
        Message oldMsg = new Message("old msg");
        Message newMsg = new Message("new msg");
        getConsole().addMessage(oldMsg);
        getConsole().replaceMessage(oldMsg, newMsg);
        assertEquals(getConsole().getMessages().iterator().next(), newMsg);
    }

    @Test
    public void testClientHasPermission() {
        EntityRef ref = createClientEntity(character);
        assertThrows(NullPointerException.class, () -> console.clientHasPermissionForTest(null, "permission string"));
        assertTrue(console.clientHasPermissionForTest(ref, ""));
        PermissionSystem permissionSystem = new PermissionSystem();
        permissionSystem.addPermission(ref, PermissionSystem.CHEAT_PERMISSION);
        assertTrue(console.clientHasPermissionForTest(ref, PermissionManager.CHAT_PERMISSION));
    }

    @Test
    public void testProcessCommandName(){
        String command = "a command         to be        cleaned";
        assertEquals("a", console.processCommandName(command)); // cleaned command should not have more spaces

        String command2 = "     command";
        assertEquals("command", console.processCommandName(command2));

    }

    @Test
    public void testProcessParameters(){
        //command name should be dropped
        String params = "commandName:  param2 param3";
        List<String> returned = Arrays.asList("param2", "param3");
        assertEquals(returned, console.processParameters(params));



        //see if splitted properly
        String params2 = "command2: param2  param3         param4       ";
        List<String> returned2 = Arrays.asList("param2", "param3", "param4");
        assertEquals(returned2, console.processParameters(params2));

        String params3 = "command2:        ";

        assertEquals(new ArrayList<>(), console.processParameters(params3));

    }

    @Test
    public void testExecute(){
        EntityRef ref = createClientEntity(character2);
        //empty command
        assertFalse(console.execute(" ", ref));

        //if command unknown, should return false and log error message
        assertFalse(console.execute("toReturn unknowncommand", ref));

        String msg = console.getMessages().iterator().next().getMessage();
        assertEquals(msg, "Unknown command 'toReturn'");
    }


    private Console getConsole() {
        return context.get(Console.class);
    }




    // source: StorageManagerTest.java
    private EntityRef createClientEntity(EntityRef charac) {
        entityManager = context.get(EngineEntityManager.class);
        ClientComponent clientComponent = new ClientComponent();
        clientComponent.local = true;
        clientComponent.character = charac;

        EntityRef clientEntity = entityManager.create(clientComponent);
        return clientEntity;
    }

    private Client createClientMock(String clientId, EntityRef charac) {
        EntityRef clientEntity = createClientEntity(charac);
        Client client = mock(Client.class);
        when(client.getEntity()).thenReturn(clientEntity);
        when(client.getId()).thenReturn(clientId);
        return client;
    }


}
