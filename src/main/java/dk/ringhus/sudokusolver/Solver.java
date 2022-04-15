package dk.ringhus.sudokusolver;

public class Solver {

    // GRIDSIZE, is used to registrate how big a sudoku is, when set to 9, its a 9x9 sudoku
    private final int GRIDSIZE = 9;

    // Check if the number already exist in the column.
    // if not return false, if yes, return true.
    private boolean checkIfNUmberIsInCol( int[][] board, int col, int number ) {
        for (int i = 0; i < GRIDSIZE; i++) {
            if( board[i][col] == number ) {
                return true;
            }
        }
        return false;
    }


    // Check if the number already exist in the row.
    // if not return false, if yes, return true.
    private boolean checkIfNumberIsInRow( int[][] board, int row, int number) {
        for (int i = 0; i < this.GRIDSIZE; i++) {
            if( board[row][i] == number ) {
                return true;
            }
        }
        return false;
    }


    // Check if the number already exist in the box.
    // if not return false, if yes return true.
    private boolean checkIfNUmberIsInBox( int[][] board, int row, int col, int number ) {
         int boxRow = row - row % 3;
         int boxCol = col - col % 3;

         for( int i = boxRow ; i < (boxRow+3) ; i++ ) {
             for (int j = boxCol; j < (boxCol+3); j++) {
                 if( board[i][j] == number ) {
                     return true;
                 }
             }
         }
         return false;
    }





    // Simple method, that checks all 3 above methods. in once.
    private boolean isPlacementValid( int[][] board, int row, int col, int number ) {
        return !checkIfNUmberIsInCol(board, col, number) &&
                !checkIfNumberIsInRow(board, row, number) &&
                !checkIfNUmberIsInBox(board, row, col, number);
    }


    // Algorithm that solves the sudoku.
    // When a valid number is set, it called it self.
    // When a number isnt valid, the method will loop one back, and that way, try with the nexst number.
    public boolean Solver( int[][] board ) {
        for( int row = 0 ; row < GRIDSIZE ; row++ ) {
            for( int col = 0 ; col < GRIDSIZE ; col++ ) {
                if( board[row][col] == 0 ) {
                    for( int tryNumber = 1 ; tryNumber <= GRIDSIZE ; tryNumber++ ) {
                        if( isPlacementValid( board, row, col, tryNumber )) {
                            board[row][col] = tryNumber;

                            if( Solver( board ) ) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    // Simple method to print board.
    public void printBoard( int[][] board ) {
        for (int row = 0; row < GRIDSIZE; row++) {
            if( row % 3 == 0 && row != 0 ) {
                System.out.println("-----------");
            }
            for (int col = 0; col < GRIDSIZE; col++) {
                if( col % 3 == 0 && col != 0 ) {
                    System.out.print("|");
                }
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }
}
