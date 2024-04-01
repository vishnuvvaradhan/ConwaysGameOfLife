/*
file name:      Cell.java
Authors:        Vishnu Varadhan
last modified:  3/4/2024

How to run:     java Cell
*/

import java.util.ArrayList;

/**
 * Implements a Cell object
 */
public class Cell {

    /**
     * The status of the Cell.
     */
    private boolean alive;
    private updateStrategy updateStrategy;

    /**
     * Constructs a dead cell.
     */
  
    public Cell(boolean status, updateStrategy strategy) {
        alive = status;
        updateStrategy = strategy;
    }

    /**
     * Constructs a cell with the specified status.
     * 
     * @param status a boolean to specify if the Cell is initially alive
     */
    public Cell(boolean status){
        this(status, new ClassicUpdateStrategy()); 
    }

    public Cell(){
        this(false, new ClassicUpdateStrategy()); 
    }

    public void setUpdateStrategy(updateStrategy strategy) {
        this.updateStrategy = strategy;
    }

    

    /**
     * Returns whether the cell is currently alive.
     * 
     * @return whether the cell is currently alive
     */
    public boolean getAlive() {
        return alive;
    }

    /**
     * Sets the current status of the cell to the specified status.
     * 
     * @param status a boolean to specify if the Cell is alive or dead
     */
    public void setAlive(boolean status) {
        alive = status;
    }

    /**
     * Updates the state of the Cell.
     * 
     * If this Cell is alive and if there are 2 or 3 alive neighbors,
     * this Cell stays alive. Otherwise, it dies.
     * 
     * If this Cell is dead and there are 3 alive neighbors,
     * this Cell comes back to life. Otherwise, it stays dead.
     * 
     * @param neighbors An ArrayList of Cells
     */
    public void updateState(ArrayList<Cell> neighbors) {
        int aliveCells = 0;
        for (Cell currCell : neighbors) {
            if(currCell.getAlive()) {
                aliveCells++;   
            }
        }
        alive = updateStrategy.shouldLive(aliveCells, alive);
    }


    /**
     * Returns a String representation of this Cell.
     * 
     * @return 1 if this Cell is alive, otherwise 0.
     */
    public String toString() {
        Boolean isAlive = getAlive();
        if(isAlive == false){
            return "0";
        }else{
            return "1";
        }
    }

    public int hashCode() {
        int result = Boolean.hashCode(alive);
        result = 31 * result + updateStrategy.getClass().hashCode();
        return result;
    }


    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cell cell = (Cell) obj;
        return alive == cell.alive && updateStrategy.getClass().equals(cell.updateStrategy.getClass());
    }


    public static void main(String[] args) {

        //Creating some initially alive n dead cells to test. 
        Cell cell1 = new Cell(true); 
        Cell cell2 = new Cell(false); 
        Cell cell3 = new Cell(true); 
        Cell cell4 = new Cell(true); 
        Cell cell5 = new Cell(false);

        // Simulate neighbors for cell2
        ArrayList<Cell> neighborsForCell2 = new ArrayList<>();
        neighborsForCell2.add(cell1);
        neighborsForCell2.add(cell3);
        neighborsForCell2.add(cell4);

        // Simulate neighbors for cell5
        ArrayList<Cell> neighborsForCell5 = new ArrayList<>();
        neighborsForCell5.add(cell1);
        neighborsForCell5.add(cell3);
        // neighborsForCell5 does not include cell4 to demonstrate a dead cell with less than 3 alive neighbors

        
        System.out.println("Initial States:");
        System.out.println("Cell1: " + cell1);
        System.out.println("Cell2: " + cell2);
        System.out.println("Cell3: " + cell3);
        System.out.println("Cell4: " + cell4);
        System.out.println("Cell5: " + cell5);

        // Update states
        cell2.updateState(neighborsForCell2); // Should become alive because it has exactly 3 alive neighbors
        cell5.updateState(neighborsForCell5); // Should stay dead because it has less than 3 alive neighbors

    
        System.out.println("Updated States:");
        System.out.println("Cell1: " + cell1);
        System.out.println("Cell2: " + cell2);
        System.out.println("Cell3: " + cell3);
        System.out.println("Cell4: " + cell4);
        System.out.println("Cell5: " + cell5);
    }
}
