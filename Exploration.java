


import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Exploration {
    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("Usage: java Exploration <rows> <columns> <iterations>");
            System.exit(1);
        }

        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);
        int iterations = Integer.parseInt(args[2]);

        // Define the range and step for the initial density
        double startDensity = 0.0;
        double endDensity = 1.0;
        double densityStep = 0.05;

        try (PrintWriter writer = new PrintWriter(new FileWriter("simulation_results.csv"))) {
            writer.println("Density | FinalLivingCells");
            //used normal forloop syntax, just using density as a metric. 
            for (double density = startDensity; density <= endDensity; density += densityStep) {
                Landscape scape = new Landscape(rows, cols, density);
                for (int i = 0; i < iterations; i++) {
                    scape.advance();
                }
                int livingCells = scape.countLivingCells();
                writer.println(density + " | " + livingCells);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

}
