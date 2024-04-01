/*
file name:      ClassicUpdateStrategy.java
Authors:        Vishnu Varadhan
last modified:  3/4/2024

How to run:     java ClassicUpdateStrategy
*/


public class ClassicUpdateStrategy implements updateStrategy {
    public boolean shouldLive(int aliveNeighbors, boolean isCurrentlyAlive) {
        return (isCurrentlyAlive && (aliveNeighbors == 2 || aliveNeighbors == 3)) || (!isCurrentlyAlive && aliveNeighbors == 3);
    }
}
