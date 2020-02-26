package org.terasology.math;

import gnu.trove.map.TObjectByteMap;
import gnu.trove.map.hash.TObjectByteHashMap;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SideBitFlagTest {

    private SideBitFlagForTest  sideBitFlag;
    private TObjectByteMap<Side> sideSet;

    @Before
    public void setup(){
        sideBitFlag = new SideBitFlagForTest();
        sideSet = sideBitFlag.getSideBits();
    }

    @Test
    public void getReverseTest(){
        //byte reverse = sideBitFlag.getReverse()
        
        byte bottom = sideBitFlag.getSideBits().get(Side.BOTTOM);
        byte top = sideSet.get(Side.TOP);
        assertEquals(bottom, sideBitFlag.getReverse(top));

        byte left = sideSet.get(Side.LEFT);
        byte right = sideSet.get(Side.RIGHT);
        assertEquals(left, sideBitFlag.getReverse(right));

        byte front = sideSet.get(Side.FRONT);
        byte back = sideSet.get(Side.BACK);
        assertEquals(front, sideBitFlag.getReverse(back));
        assertFalse(front == bottom);
    }
}
