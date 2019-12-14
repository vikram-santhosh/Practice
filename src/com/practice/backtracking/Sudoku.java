package com.practice.backtracking;

/**
 * Created by Flinstone on 17-Nov-19.
 */
public class Sudoku {


    public boolean validate(char[][] board, int n, int r, int c, char val) {

        // check column
        for(int i=0;i<n;i++) if (board[r][i] == val) return false;

        // check column
        for(int i=0;i<n;i++) if (board[i][c] == val) return false;

        int sub_grid_row_index = r / 3;
        int sub_grid_col_index = c / 3;

        // check sub grid
        for(int i=sub_grid_row_index*3;i<sub_grid_row_index*3+3;i++) {
            for(int j=sub_grid_col_index*3; j<sub_grid_col_index*3+3;j++) {
                if (board[i][j] == val) return false;
            }
        }
        return true;
    }

    public boolean solve(char[][] board, int row, int col, int n) {
        if ( col == n) {
            col = 0;
            row ++;
            if( row == n) {
                return true;
            }
        }

        // if piece is not empty, move to next column
        if (board[row][col] != '.') return solve(board, row, col+1, n);

        for(int i=1;i<=n;i++) {
            char val = (char) ('0' + i);

            if (validate(board, n, row, col, val)) {
                board[row][col] = val;
                if (solve(board, row, col+1, n)) {
                    return true; // if next piece can be placed , keep the current piece
                }
                board[row][col] = '.'; // remove piece if next placement is not valid
            }

        }
        return false; // no value can be placed here. Remove previous piece

    }
    public void solveSudoku(char[][] board) {
        int n = board.length;
        solve(board, 0, 0, n);
    }
}