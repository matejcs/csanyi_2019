package com.csanyi.bnp;

import java.util.Objects;

/**
 * Simple wrapper to represent a 2D coordinate in the maze.
 */
public class Location {

    public final int x, y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x &&
                y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}