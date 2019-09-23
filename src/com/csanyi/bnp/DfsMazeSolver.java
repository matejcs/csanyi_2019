package com.csanyi.bnp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implements a breadth first search maze solver.
 */
public class DfsMazeSolver implements MazeSolver {

    // Defines the directions in which we are allowed to move
    private final Location[] directions = {
            new Location(-1, 0),
            new Location(1, 0),
            new Location(0, 1),
            new Location(0, -1)
    };

    /**
     * Finds a path, and marks it on the maze, from the Start (S) point to the End (E) point.
     * @param maze the maze to be solved.
     * @return the maze itself.
     */
    public Maze solveMaze(final Maze maze) {
        final Location start = maze.getStartLocation();
        final Set<Location> visited = new HashSet<>();
        final Map<Location, Location> paths = new HashMap<>(); // Next to previous mapping
        final Queue<Location> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Location current = queue.poll();
            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);
            if (maze.isAtEnd(current.x, current.y)) {
                markPath(maze, paths, paths.get(current), start);
                return maze;
            }
            Set<Location> neighbors = findNeighbors(maze, current, visited);
            neighbors.forEach(neighbor -> paths.put(neighbor, current));
            queue.addAll(neighbors);
        }
        return maze;
    }

    private void markPath(final Maze maze, final Map<Location, Location> paths, Location previous, final Location start) {
        while (previous != start) {
            maze.markLocationAsPath(previous.x, previous.y);
            previous = paths.get(previous);
        }
    }

    private Set<Location> findNeighbors(final Maze maze, final Location location, final Set<Location> visited) {
        return Arrays.stream(directions)
                .map(d -> new Location(location.x + d.x, location.y + d.y))
                .filter(l -> maze.locationValid(l.x, l.y))
                .filter(l -> !visited.contains(l))
                .collect(Collectors.toSet());
    }

}
