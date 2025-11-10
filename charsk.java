import java.util.*;
public class charsk{
    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        int row = 0, col = 0;
        if (solveSudoku(board,row,col)) {
            System.out.println("Solution exists");
        }
        else{
            System.out.println("Solution does not exist");
        }
    }

    public static boolean solveSudoku(char[][] board, int row, int col) {
        // base case
        if (row==board.length) {
            return true;
        }
        // recursive case
        int nextRow = row, nextCol = col + 1;
        if(nextCol == board.length) {
            nextRow++;
            nextCol = 0;
        }
        if (board[row][col] != '.') {
            return solveSudoku(board, nextRow, nextCol);
        }
        for(char digit ='1'; digit <= '9'; digit++) {
            if (isSafe(board, row, col, digit)) {
                board[row][col] = digit;        
                if (solveSudoku(board, nextRow, nextCol)) {
                    return true;
                }
                board[row][col] = '.'; // backtrack
            }
        }
        return false;
        
    }

    public static boolean isSafe(char[][] board, int row, int col, char digit) {
        // Check row and column
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == digit || board[i][col] == digit) {
                return false;
            }
        }
        // Check 3x3 box
         int sR  = (row/3)*3;
        int sC = (col/3)*3;
        for (int i = sR; i < sR+3; i++) {
            for (int j = sC; j < sC+3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }   
        return true;
        
}
    // public static void printBoard(int[][] board) {
    //     for (int r = 0; r < board.length; r++) {
    //         for (int d = 0; d < board[0].length; d++) {
    //             System.out.print(board[r][d]);
    //             System.out.print(" ");
    //         }
    //         System.out.println();
    //     }
    // }
}