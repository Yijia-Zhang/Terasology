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

        byte bottom = sideBitFlag.getSide(Side.BOTTOM);
        byte top = sideBitFlag.getSide(Side.TOP);
        assertEquals(bottom, sideBitFlag.getReverse(top));

        byte left = sideBitFlag.getSide(Side.LEFT);
        byte right = sideBitFlag.getSide(Side.RIGHT);
        assertEquals(left, sideBitFlag.getReverse(right));

        byte front = sideBitFlag.getSide(Side.FRONT);
        byte back = sideBitFlag.getSide(Side.BACK);
        assertEquals(front, sideBitFlag.getReverse(back));
        assertFalse(front == bottom);
    }
}
