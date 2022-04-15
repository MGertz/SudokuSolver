package dk.ringhus.sudokusolver;

public class Main {

    public static void main(String[] args) {
        int[][] sudokuboard = {
                {7,0,2,0,5,0,6,0,0},
                {0,0,0,0,0,3,0,0,0},
                {1,0,0,0,0,9,5,0,0},
                {8,0,0,0,0,0,0,9,0},
                {0,4,3,0,0,0,7,5,0},
                {0,9,0,0,0,0,0,0,8},
                {0,0,9,7,0,0,0,0,5},
                {0,0,0,2,0,0,0,0,0},
                {0,0,7,0,4,0,2,0,3}
        };

        Solver solve = new Solver();
        solve.printBoard( sudokuboard );
        solve.Solver( sudokuboard );
        System.out.println("\nSOLVED BOARD\n");
        solve.printBoard( sudokuboard );

    }






}
