Added the following commands to Grid.java:
- Usage: java Grid <rotate>: rotates an array and prints it to terminal 
- Usage: java Grid <length>: prints length of array, rows and columns
Added the following commands to LifeSimulation.java
- Usage: java LifeSimulation <rows> <columns> <density> <iterations>
Added the following commands to AnimationCreation.java:
- Usage: java LifeSimulation <rows> <columns> <iterations>


Extensions:
Different Cell Types
I introduced the concept of different cell types, specifically including an "aggressive" cell type alongside the classic cell type. 
This was achieved through the use of an interface, updateStrategy, which allowed me to define a common structure for implementing
different behaviors for how cells decide whether to stay alive or die in each simulation step. This interface enabled me to encapsulate 
the behavior of cells in separate classes, ClassicUpdateStrategy and AggressiveUpdateStrategy, each adhering to the updateStrategy 
interface but implementing its method to define unique rules for cell survival. To accommodate these strategies within the cell population, 
I modified the Cell class to include a constructor that accepts both an alive status and an updateStrategy instance. This approach allowed 
each cell to be instantiated with a specific behavior, enabling the creation of a diverse ecosystem within the simulation where cells can 
follow different rules for their evolution. Additionally, I provided overloaded constructors for the Cell class that default to using the 
ClassicUpdateStrategy when no strategy is specified, ensuring backward compatibility and ease of use for creating standard cells. 
In the reset method of the Landscape class, I introduced randomness not just in determining the initial alive or dead status of each 
cell but also in deciding whether each cell would follow the classic or aggressive strategy. This was implemented by generating a 
random chance for each cell to determine its type, thereby initializing the grid with a mix of both aggressive and classic cells. This 
randomness introduces variability and complexity into the simulation, making the evolution of the grid more unpredictable and interesting.


Command Line Arguments
Added usage and command line arguments for the user to pick rows, columns, iterations and density of the grid from the terminal. Added this to each class that requires users to run the code.
