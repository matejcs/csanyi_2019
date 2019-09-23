package com.csanyi.bnp;

import org.junit.Assert;
import org.junit.Test;

public class MazeBuilderTest {

    @Test
    public void testMazeBuilderFromStringSingleStartLocation() {
        Assert.assertEquals(new Location(0, 0), MazeBuilder.buildMaze("S").getStartLocation());
    }

    @Test
    public void testMazeBuilderFromStringSimpleRow() {
        Assert.assertEquals(new Location(0, 0), MazeBuilder.buildMaze("S E").getStartLocation());
        Assert.assertTrue(MazeBuilder.buildMaze("S E").isAtEnd(0, 2));
    }

    @Test
    public void testMazeBuilderFromStringTwoRows() {
        Assert.assertEquals(new Location(0, 1), MazeBuilder.buildMaze(".S.\n  E").getStartLocation());
        Assert.assertTrue(MazeBuilder.buildMaze(".S.\n  E").isAtEnd(1, 2));
    }

}
