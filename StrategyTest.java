import java.util.ArrayList;

public class StrategyTest {
    public static void main(String[] args) {
        Cell classicCell = new Cell(true, new ClassicUpdateStrategy());
        Cell aggressiveCell = new Cell(true, new AggressiveUpdateStrategy());

        ArrayList<Cell> neighbors = new ArrayList<>();
        neighbors.add(new Cell(true));
        neighbors.add(new Cell(false)); 
        neighbors.add(new Cell(true)); 
        neighbors.add(new Cell(true)); 

        classicCell.updateState(neighbors);
        aggressiveCell.updateState(neighbors);

        System.out.println("After updating with 3 alive neighbors:");
        System.out.println("ClassicCell alive: " + classicCell.getAlive());
        System.out.println("AggressiveCell alive: " + aggressiveCell.getAlive());
    }
}