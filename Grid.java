import java.util.Arrays;

class Grid {
    public static void main(String[] args) {



        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        if (args.length == 0) {
            System.out.println("    Usage: java [options]  [args...]\r\n" + //
                    "        (to execute a class)\r\n" + //
                    "or  java [options] -jar  [args...]\r\n" + //
                    "        (to execute a jar file)\r\n" + //
                    "or  java [options] -m [/] [args...]\r\n" + //
                    "    java [options] --module [/] [args...]\r\n" + //
                    "        (to execute the main class in a module)\r\n" + //
                    "or  java [options]  [args]\r\n" + //
                    "        (to execute a single source-file program)");
        }
        
        if(args[0].equals("Rotate")){
            System.out.println("Rotating...");

            int gridtoRotate[][] = new int[5][5];

            for (int i = 0; i < gridtoRotate.length; i++) {
                for (int j = 0; j < gridtoRotate[i].length; j++) {
                    gridtoRotate[i][j] = j + 1;
                }
            }


            System.out.println("GridtoRotate Original:  " + Arrays.deepToString(gridtoRotate));

            int newGrid[][] = rotate(gridtoRotate);
    
            System.out.println("GridtoRotate Rotated:  " +Arrays.deepToString(newGrid));
        }
        
        if (args[0].equals("Length")){

            int gridtoRotate[][] = new int[5][5];

            for (int i = 0; i < gridtoRotate.length; i++) {
                for (int j = 0; j < gridtoRotate[i].length; j++) {
                    gridtoRotate[i][j] = j + 1;
                }
            }

            System.out.println("Rows: " + gridtoRotate.length);
            System.out.println("Columns: " +  gridtoRotate[0].length);
        }

        int grid[][];
        grid = new int[5][5];

        System.out.println(grid);
        System.out.println(grid[0][0]);

        grid = new int[3][];
        for (int i = 0; i < 3; i++) {
            grid[i] = new int[i + 3];
        }

        System.out.println(grid);
        System.out.println(grid[0][0]);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = j + 1;
            }
        }

        System.out.println(grid);
        System.out.println(grid[1][1]);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(i + ", " + j + ", ");
            }
        }

        System.out.println();

        System.out.println(Arrays.deepToString(grid));

        int grid2[][];

        grid2 = new int[5][5];

        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                grid2[i][j] = j + 1;
            }
        }


        assert !gridEquals(grid, grid2) : "Arrays are not equal";
        
        int gridtoRotate[][] = new int[5][5];

        for (int i = 0; i < gridtoRotate.length; i++) {
            for (int j = 0; j < gridtoRotate[i].length; j++) {
                gridtoRotate[i][j] = j + 1;
            }
        }

        //System.out.println("GridtoRotate Original:  " +Arrays.deepToString(gridtoRotate));

        int newGrid[][] = rotate(gridtoRotate);

        //System.out.println("GridtoRotate Rotated:  " +Arrays.deepToString(newGrid));

        assert !gridEquals(gridtoRotate, newGrid) : "Arrays are not equal";

    }

    public static boolean gridEquals(int[][] grid, int[][] grid2) {
        
        if (grid.length != grid2.length) {
            return false;
        }

        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid[i][j] != grid2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static int[][] rotate(int[][] arr){
        int totalRows = arr.length;
        int totalCols = arr[0].length;
        if(arr == null || arr.length == 0 || arr[0].length == 0){
            return arr;
        }
        int[][] rotatedArr = new int[totalCols][totalRows];

        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                rotatedArr[j][totalRows - 1 - i] = arr[i][j];
            }
        }
        return rotatedArr;
    }



}
