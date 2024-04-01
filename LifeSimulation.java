/*
file name:      LifeSimulation.java
Authors:        Vishnu Varadhan
last modified:  3/4/2024

How to run:     java LifeSimulation
*/




public class LifeSimulation {

    public static void main(String[] args) throws InterruptedException {

        if (args.length < 4) {
            System.out.println("Usage: java LifeSimulation <rows> <columns> <density> <iterations>");

        }

        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);
        double density = Double.parseDouble(args[2]);
        int iterations = Integer.parseInt(args[3]);

        Landscape scape = new Landscape(rows, cols, density);
        //Landscape scape = new Landscape(rows, cols, "Glider");


        LandscapeDisplay display = new LandscapeDisplay(scape, 6);

        display.repaint();
        Thread.sleep(400);
        
        for (int i = 0; i < iterations; i++) {
            Thread.sleep(300);
            scape.advance();
            display.repaint();
        }
    }
}
