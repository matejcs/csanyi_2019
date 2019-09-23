package com.csanyi.bnp;

/**
 * Represents a maze. Should have no dependency on any other classes to have minimum coupling. Provides basic methods
 * to enable clients to work with the maze.
 */
public class Maze {

    private static final char START = 'S';
    private static final char END = 'E';
    private static final char EMPTY = ' ';
    private static final char WALL = '#';
    private static final char PATH = '.';

    private final char[][] maze;

    public Maze(char[][] maze) {
        if (maze == null || maze.length == 0) {
            throw new IllegalArgumentException("Cannot have an empty maze");
        }
        int columns = maze[0].length;
        for (char[] row: maze) {
            if (row.length != columns) {
                throw new IllegalArgumentException("Maze must have uniform row length");
            }
        }
        this.maze = maze;
    }

    public Location getStartLocation() {
        for (int row = 0; row < maze.length; ++row) {
            for (int col = 0; col < maze[0].length; ++col) {
                if (maze[row][col] == START) {
                    return new Location(row, col);
                }
            }
        }
        throw new IllegalStateException("Maze does not have a start point [S]");
    }

    public void markLocationAsPath(int x, int y) {
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length) {
            throw new IllegalArgumentException("Location outside of the bounds of the maze array");
        }
        if (maze[x][y] != EMPTY) {
            throw new IllegalArgumentException("Location [" + x + "," + y + "] invalid, path can only be placed on an empty location");
        }
        maze[x][y] = PATH;
    }

    public String stringRepresentation() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] chars : maze) {
            for (int j = 0; j < maze[0].length; ++j) {
                stringBuilder.append(chars[j]);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    public boolean locationValid(int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] != WALL;
    }

    public boolean isAtEnd(int x, int y) {
        return maze[x][y] == END;
    }
}
