package com.csanyi.bnp;

import org.junit.Assert;
import org.junit.Test;

public class DfsMazeSolverTest {

    @Test
    public void testSimpleMazeResolution() {
        Maze maze = MazeBuilder.buildMaze("S  \n  E");
        String mazeStr = new DfsMazeSolver().solveMaze(maze).stringRepresentation();
        Assert.assertEquals("S..\n  E", mazeStr);
    }

    @Test
    public void testSimpleMazeResolutionWhenStartAndEndNextToEachOther() {
        Maze maze = MazeBuilder.buildMaze("SE");
        String mazeStr = new DfsMazeSolver().solveMaze(maze).stringRepresentation();
        Assert.assertEquals("SE", mazeStr);
    }

    @Test
    public void testSimpleMazeResolutionWhenNoPathExists() {
        Maze maze = MazeBuilder.buildMaze("S  \n###\n  E");
        String mazeStr = new DfsMazeSolver().solveMaze(maze).stringRepresentation();
        Assert.assertEquals("S  \n###\n  E", mazeStr);
    }

    @Test
    public void test7RowedMazeResolution() {
        Maze maze = MazeBuilder.buildMaze("#######\n#     #\n# #    \n# # # #\n# #E# #\n# ### #\n#S # # \n#######");
        String mazeStr = new DfsMazeSolver().solveMaze(maze).stringRepresentation();
        Assert.assertEquals("#######\n#...  #\n#.#.   \n#.#.# #\n#.#E# #\n#.### #\n#S # # \n#######", mazeStr);
    }


    @Test
    public void test11RowedMazeResolution() {
        String mazeDef = "#########\n#S       \n######## \n#        \n# #######\n#        \n#        \n#        \n#        \n#       E\n#########";
        Maze maze = MazeBuilder.buildMaze(mazeDef);
        String mazeStr = new DfsMazeSolver().solveMaze(maze).stringRepresentation();
        Assert.assertEquals("#########\n" +
                "#S.......\n" +
                "########.\n" +
                "#........\n" +
                "#.#######\n" +
                "#........\n" +
                "#       .\n" +
                "#       .\n" +
                "#       .\n" +
                "#       E\n" +
                "#########", mazeStr);
    }

    @Test
    public void test11RowedMazeResolution2() {
        String mazeDef = "#########\nS        \n#        \n##       \n###      \n####     \n#### ####\n         \n ####### \n    E    \n#########";
        Maze maze = MazeBuilder.buildMaze(mazeDef);
        String mazeStr = new DfsMazeSolver().solveMaze(maze).stringRepresentation();
        Assert.assertEquals("#########\n" +
                "S....    \n" +
                "#   .    \n" +
                "##  .    \n" +
                "### .    \n" +
                "####.    \n" +
                "####.####\n" +
                "    .....\n" +
                " #######.\n" +
                "    E....\n" +
                "#########", mazeStr);
    }

    @Test
    public void test8RowedMazeResolution() {
        String mazeDef = "#########\n    S    \n#### ####\n#### ####\n         \n ####### \n    E    \n#########";
        Maze maze = MazeBuilder.buildMaze(mazeDef);
        String mazeStr = new DfsMazeSolver().solveMaze(maze).stringRepresentation();
        Assert.assertEquals("#########\n" +
                "    S    \n" +
                "####.####\n" +
                "####.####\n" +
                "    .....\n" +
                " #######.\n" +
                "    E....\n" +
                "#########", mazeStr);
    }


}
