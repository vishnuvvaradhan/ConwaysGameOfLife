/*
file name:      Landscape.java
Authors:        Vishnu Varadhan
last modified:  3/4/2024

How to run:     java Landscape
*/



import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Landscape {

    private int iterationCounter = 0;

    private Set<Integer> previousStates;

    /**
     * The underlying grid of Cells for Conway's Game
     */
    private Cell[][] landscape;

    /**
     * The original probability each individual Cell is alive
     */
    private double initialChance;

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * All Cells are initially dead.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     */
    public Landscape(int rows, int columns) {
        landscape = new Cell[rows][columns];
        previousStates = new HashSet<>();
        reset();
    }

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * Each Cell is initially alive with probability specified by chance.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     * @param chance  the probability each individual Cell is initially alive
     */
    public Landscape(int rows, int columns, double chance) {
        landscape = new Cell[rows][columns];
        initialChance = chance;
        previousStates = new HashSet<>();
        reset();
    }


    public Landscape(int rows, int columns, String pattern) {
        landscape = new Cell[rows][columns];
        previousStates = new HashSet<>();
        reset();
        if (pattern.equals("Glider") && (rows >= 3 && columns >= 3)) {
                getCell(1, 0).setAlive(true);
                getCell(2, 1).setAlive(true);
                getCell(0, 2).setAlive(true);
                getCell(1, 2).setAlive(true);
                getCell(2, 2).setAlive(true);
            }else if (pattern.equals("Beacon") && rows >= 4 && columns >= 4) {
                getCell(1, 1).setAlive(true);
                getCell(1, 2).setAlive(true);
                getCell(2, 1).setAlive(true);
                getCell(2, 2).setAlive(true);
                getCell(3, 3).setAlive(true);
                getCell(3, 4).setAlive(true);
                getCell(4, 3).setAlive(true);
                getCell(4, 4).setAlive(true);
            }
        }

    /**
     * Recreates the Landscape according to the specifications given
     * in its initial construction.
     */
    public void reset() {
            Random rand = new Random();
            Random rand2 = new Random();
            for (int i = 0; i < landscape.length; i++) {
                for (int j = 0; j < landscape[i].length; j++) {
                    double chance = rand.nextDouble();
                    double cell_chance = rand2.nextDouble();
                    boolean cellStatus = chance <= initialChance;
                    boolean cellType = cell_chance <= initialChance;
                    if(cellType){
                    landscape[i][j] = new Cell(cellStatus, new ClassicUpdateStrategy());
                    }else if(!cellType){
                        landscape[i][j] = new Cell(cellStatus, new AggressiveUpdateStrategy());
                    }
                }
            }
    }

    /**
     * Returns the number of rows in the Landscape.
     * 
     * @return the number of rows in the Landscape
     */
    public int getRows() {
        return landscape.length;
    }

    /**
     * Returns the number of columns in the Landscape.
     * 
     * @return the number of columns in the Landscape
     */
    public int getCols() {
        return landscape[0].length;
    }

    /**
     * Returns the Cell specified the given row and column.
     * 
     * @param row the row of the desired Cell
     * @param col the column of the desired Cell
     * @return the Cell specified the given row and column
     */
    public Cell getCell(int row, int col) {
        return landscape[row][col];
    }

    /**
     * Returns a String representation of the Landscape.
     */
    public String toString() {
        return Arrays.deepToString(landscape);
    }

    /**
     * Returns an ArrayList of the neighboring Cells to the specified location.
     * 
     * @param row the row of the specified Cell
     * @param col the column of the specified Cell
     * @return an ArrayList of the neighboring Cells to the specified location
     */
    public ArrayList<Cell> getNeighbors(int row, int col) {
        ArrayList<Cell> neighbors = new ArrayList<Cell>();

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < landscape.length && j >= 0 && j < landscape[i].length && !(i == row && j == col)) {
                    neighbors.add(landscape[i][j]);
            }
        }
    }
        return neighbors;
    }

    /**
     * Advances the current Landscape by one step. 
     */
    public void advance() {
        iterationCounter++;
        if(iterationCounter % 4 == 0){
            int currentStateHash = Arrays.deepHashCode(landscape);
            if (!previousStates.add(currentStateHash)) {
                System.out.println("Loop detected. Stopping further advancements.");
            }
        }

        Cell[][] updateLandscape = new Cell[getRows()][getCols()];
        for (int i = 0; i < updateLandscape.length; i++) {
            for (int j = 0; j < updateLandscape[i].length; j++) {
                Cell grabCell = getCell(i, j);
                Cell tempCell = new Cell(grabCell.getAlive());
                tempCell.updateState(getNeighbors(i, j));
                if(tempCell.getAlive()){
                    updateLandscape[i][j] = new Cell(true);
                }else{
                    updateLandscape[i][j] = new Cell(false);
                }
            }
        }
        landscape = updateLandscape;
     }

    /**
     * Draws the Cell to the given Graphics object at the specified scale.
     * An alive Cell is drawn with a black color; a dead Cell is drawn gray.
     * 
     * @param g     the Graphics object on which to draw
     * @param scale the scale of the representation of this Cell
     */
    public void draw(Graphics g, int scale) {
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++) {
                g.setColor(getCell(x, y).getAlive() ? Color.BLACK : Color.gray);
                g.fillOval(x * scale, y * scale, scale, scale);
            }
        }
    }

    //Counts Living Cells in landscape
    public int countLivingCells(){
        int cellCount = 0;
        for (int i = 0; i < landscape.length; i++) {
            for (int j = 0; j < landscape[i].length; j++) {
                if(landscape[i][j].getAlive()){
                    cellCount++;
                }  
            }
        }
        return cellCount;
    }

    public static void main(String[] args) {
        Landscape test = new Landscape(5, 5, 0.5);
        System.out.println(test);
        System.out.println(test.getCell(2, 2));
        System.out.println(test.getRows() + " " + test.getCols());
        System.out.println(test.getNeighbors(0, 0));
        System.out.println(test.getCell(4, 4));
    }
}
