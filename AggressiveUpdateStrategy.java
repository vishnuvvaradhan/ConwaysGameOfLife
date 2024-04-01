/*
file name:      AgressiveUpdateSrategy.java
Authors:        Vishnu Varadhan
last modified:  3/4/2024

How to run:     java AgressiveUpdateSrategy
*/



/**
 * Implements the aggressive update strategy for cells in Conway's Game of Life.
 * A cell will live if it has 3 to 4 neighbors that are alive.
 */
public class AggressiveUpdateStrategy implements updateStrategy {

    /**
     * Determines whether a cell should live in the next iteration.
     * 
     * @param aliveNeighbors The number of alive neighbors around the cell.
     * @param isCurrentlyAlive The current state of the cell (alive or not).
     * @return true if the cell should live, false otherwise.
     */
    @Override
    public boolean shouldLive(int aliveNeighbors, boolean isCurrentlyAlive) {
        // A cell remains or becomes alive if it has 3 or 4 alive neighbors
        return aliveNeighbors >= 3 && aliveNeighbors <= 4;
    }
}