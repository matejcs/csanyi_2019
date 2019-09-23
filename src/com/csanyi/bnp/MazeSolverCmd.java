package com.csanyi.bnp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Command line maze solver.
 */
public class MazeSolverCmd {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new IllegalArgumentException("Provide a text file representing the maze as the first argument");
        }
        String mazeInput = Files.readString(Path.of(args[0]));
        Maze maze = MazeBuilder.buildMaze(mazeInput);
        MazeSolver mazeSolver = new DfsMazeSolver();
        System.out.println(mazeSolver.solveMaze(maze).stringRepresentation());
    }

}
