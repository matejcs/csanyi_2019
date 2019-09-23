package com.csanyi.bnp;

public class MazeBuilder {

    public static Maze buildMaze(String mazeStr) {
        String[] rows = mazeStr.split("\\R");
        char[][] mazeArray = new char[rows.length][];
        for (int row = 0; row < rows.length; ++row) {
            mazeArray[row] = rows[row].toCharArray();
        }
        return new Maze(mazeArray);
    }

}
