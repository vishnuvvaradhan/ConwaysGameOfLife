/**
 * The AnimationCreation class is responsible for setting up and running
 * a visualization of Conway's Game of Life with a specified pattern,
 * dimensions, and number of iterations.
 */
public class AnimationCreation {
    public static void main(String[] args) throws InterruptedException {
        // Check for correct number of command line arguments
        if (args.length < 3) {
            System.out.println("Usage: java AnimationCreation <rows> <columns> <iterations>");
            System.exit(1); // Exit if not enough arguments are provided
        }

        // Parse command line arguments
        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);
        int iterations = Integer.parseInt(args[2]);

        // Initialize the landscape with the specified pattern and dimensions
        Landscape scape = new Landscape(rows, cols, "Beacon");
        // Create a display for visualizing the landscape
        LandscapeDisplay display = new LandscapeDisplay(scape, 6);

        // Initial repaint to display the starting state
        display.repaint();
        // Pause before starting the animation loop
        Thread.sleep(1000);
        
        // Main animation loop for the specified number of iterations
        for (int i = 0; i < iterations; i++) {
            // Pause to control the speed of the animation
            Thread.sleep(100);
            // Advance the simulation by one step
            scape.advance();
            // Repaint the display to reflect the current state
            display.repaint();
        }
    }
}