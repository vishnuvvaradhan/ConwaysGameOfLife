public interface updateStrategy {
    boolean shouldLive(int aliveNeighbors, boolean isCurrentlyAlive);  
}
