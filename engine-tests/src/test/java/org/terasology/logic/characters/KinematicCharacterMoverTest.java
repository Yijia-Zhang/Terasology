/*
 * Copyright 2015 MovingBlocks
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
package org.terasology.logic.characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 */
public class KinematicCharacterMoverTest {

    @Test
    public void testUpdateMode() {
        CharacterStateEvent state = new CharacterStateEvent();

        state.setMode(MovementMode.WALKING);
        KinematicCharacterMover.updateMode(state, true, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, true);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, true);
        assertSame(MovementMode.CROUCHING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, false);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, false);
        assertSame(MovementMode.WALKING, state.getMode());

        state.setMode(MovementMode.CROUCHING);
        KinematicCharacterMover.updateMode(state, true, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, true);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, true);
        assertSame(MovementMode.CROUCHING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, false);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, false);
        assertSame(MovementMode.WALKING, state.getMode());

        state.setMode(MovementMode.DIVING);
        KinematicCharacterMover.updateMode(state, true, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, true);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, true);
        assertSame(MovementMode.CROUCHING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, false);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, false);
        assertSame(MovementMode.WALKING, state.getMode());

        state.setMode(MovementMode.SWIMMING);
        KinematicCharacterMover.updateMode(state, true, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, true);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, true);
        assertSame(MovementMode.CROUCHING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, false);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, false);
        assertSame(MovementMode.WALKING, state.getMode());

        state.setMode(MovementMode.CLIMBING);
        KinematicCharacterMover.updateMode(state, true, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, true);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, true);
        assertSame(MovementMode.CROUCHING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, false);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, false);
        assertSame(MovementMode.WALKING, state.getMode());

        state.setMode(MovementMode.FLYING);
        KinematicCharacterMover.updateMode(state, true, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, true);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, true);
        assertSame(MovementMode.FLYING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, false);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, false);
        assertSame(MovementMode.FLYING, state.getMode());

        state.setMode(MovementMode.GHOSTING);
        KinematicCharacterMover.updateMode(state, true, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, true);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, true);
        assertSame(MovementMode.GHOSTING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, false);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, false);
        assertSame(MovementMode.GHOSTING, state.getMode());

        state.setMode(MovementMode.NONE);
        KinematicCharacterMover.updateMode(state, true, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, true);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, true);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, true, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, true);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, true, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, true);
        assertSame(MovementMode.NONE, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, true, false);
        assertSame(MovementMode.CLIMBING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, true, false, false);
        assertSame(MovementMode.DIVING, state.getMode());
        KinematicCharacterMover.updateMode(state, true, false, false, false);
        assertSame(MovementMode.SWIMMING, state.getMode());
        KinematicCharacterMover.updateMode(state, false, false, false, false);
        assertSame(MovementMode.NONE, state.getMode());
    }
}
