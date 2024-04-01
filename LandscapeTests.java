/*
file name:      LandscapeTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  9/18/2022

How to run:     java -ea LandscapeTests
*/


import java.util.ArrayList;

public class LandscapeTests {

    public static void landscapeTests() {

        // case 1: testing Landscape(int, int)
        {
            // set up
            Landscape l1 = new Landscape(2, 4);
            Landscape l2 = new Landscape(10, 10);
    
            // verify
            System.out.println(l1);
            System.out.println("\n");
            System.out.println(l2);
    
            // test
            assert l1 != null : "Error in Landscape::Landscape(int, int)";
            assert l2 != null : "Error in Landscape::Landscape(int, int)";
        }
    
        // case 2: testing reset()
        {
            // set up
            Landscape l = new Landscape(5, 5, 0.5);
            l.reset();
    
            // verify & test
            System.out.println("Reset landscape:\n" + l);
        }
    
        // case 3: testing getRows()
        {
            // set up
            Landscape l = new Landscape(3, 5);
    
            // verify
            int rows = l.getRows();
    
            // test
            assert rows == 3 : "Error in getRows";
        }
    
        // case 4: testing getCols()
        {
            // set up
            Landscape l = new Landscape(3, 5);
    
            // verify
            int cols = l.getCols();
    
            // test
            assert cols == 5 : "Error in getCols";
        }
    
        // case 5: testing getCell(int, int)
        {
            // set up
            Landscape l = new Landscape(2, 2);
            l.reset();
    
            // verify
            Cell cell = l.getCell(0, 0);
    
            // test
            assert cell != null : "getCell(0, 0) returned null";
        }
    
        // case 6: testing getNeighbors()
        {
            // set up
            Landscape l = new Landscape(3, 3, 0.5);
            l.reset();
    
            // verify
            ArrayList<Cell> neighbors = l.getNeighbors(1, 1);
    
            // test
            assert neighbors.size() == 8 : "Expected 8 neighbors, got " + neighbors.size();
        }
    
        // case 7: testing advance()
        {
            // set up
            Landscape l = new Landscape(3, 3);
            l.reset();
            l.getCell(1, 0).setAlive(true);
            l.getCell(1, 1).setAlive(true);
            l.getCell(1, 2).setAlive(true);
            System.out.println("Before Update" + l);
    
            // verify
            l.advance();
    
            // test 
            System.out.println("Updated: " + l);
            assert l.getCell(0, 1).getAlive() : "Cell (0, 1) should be alive";
            assert l.getCell(1, 1).getAlive() : "Cell (1, 1) should be alive";
            assert l.getCell(2, 1).getAlive() : "Cell (2, 1) should be alive";
            assert !l.getCell(1, 0).getAlive() : "Cell (1, 0) should be dead";
            assert !l.getCell(1, 2).getAlive() : "Cell (1, 2) should be dead";
        }
    }

    public static void main(String[] args) {

        landscapeTests();
    }
}