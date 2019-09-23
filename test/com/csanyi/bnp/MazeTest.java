package com.csanyi.bnp;

import org.junit.Assert;
import org.junit.Test;

public class MazeTest {

    @Test
    public void testMaze() {
        String mazeStr = "S  \n  E";
        Maze maze = MazeBuilder.buildMaze(mazeStr);
        Assert.assertTrue(maze.isAtEnd(1, 2));
        Assert.assertEquals(new Location(0, 0), maze.getStartLocation());
        Assert.assertEquals(mazeStr, maze.stringRepresentation());
        Assert.assertTrue(maze.locationValid(1, 1));
    }

    @Test(expected = IllegalStateException.class)
    public void testStartLocationHasToBePresent() {
        Maze maze = MazeBuilder.buildMaze(" E ");
        maze.getStartLocation();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectPathMarkingWhenOutsideBounds() {
        Maze maze = MazeBuilder.buildMaze("#E#");
        maze.markLocationAsPath(-1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectPathMarkingWhenOnWall() {
        Maze maze = MazeBuilder.buildMaze("#E#");
        maze.markLocationAsPath(0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectPathMarkingWhenOnStart() {
        Maze maze = MazeBuilder.buildMaze("S E");
        maze.markLocationAsPath(0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectPathMarkingWhenOnEnd() {
        Maze maze = MazeBuilder.buildMaze("S E");
        maze.markLocationAsPath(0, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullMazeArray() {
        new Maze(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMazeArray() {
        new Maze(new char[][]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNonUniformMazeArray() {
        new Maze(new char[][]{{'S'}, {' ', 'E'}});
    }


}
