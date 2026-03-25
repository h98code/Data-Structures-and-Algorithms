package org.Projects.BackTracking;

public class SudokuSolver {


    public void solveSudoku(char[][] board) {
        helper(board);
    }

    public boolean helper(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){

                if(board[i][j] != '.')
                    continue;

                for(int val=1; val<=9; val++){ //for a given cell, checking all the possible candidates
                    if(canPlace(board, val, i, j, board.length, board[0].length)){

                        board[i][j] = (char)('0' + val);

                        //recursive calls to solve the board
                        if(helper(board))
                            return true;

                        //backtrack if the solution not found
                        board[i][j] = '.';
                    }
                }

                //if none of the numbers can be placed
                return false;
            }
        }

        //if the board is fully traversed while placing the numbers => sudoku is solved
        return true;
    }

    //checks if the number can be placed at the given position or not, by checking the row, column and the block.
    private boolean canPlace(char[][] board, int num, int r, int c, int rows, int cols){
        char ch = (char)(num + '0');

        if(isInColumn(board, ch, c, rows) || isInRow(board, ch, r, cols) || isInBlock(board, ch, r, c))
            return false;

        return true;
    }

    //checks if duplicate exists in the same col.
    private boolean isInColumn(char[][] board, char ch, int col, int rows){
        for(int i=0; i<rows; i++){
            if(board[i][col] == ch)
                return true;
        }

        return false;
    }

    //check if duplicate exists in the same row.
    private boolean isInRow(char[][] board, char ch, int r, int cols){
        for(int i=0; i<cols; i++){
            if(board[r][i] == ch)
                return true;
        }

        return false;
    }

    //check if the number exists in the block or not
    private boolean isInBlock(char[][] board, char ch, int r, int c){
        int stRow = (r/3)*3;
        int stCol = (c/3)*3;

        for(int i=stRow; i<stRow+3; i++){
            for(int j=stCol; j<stCol+3; j++){
                if(board[i][j] == ch)
                    return true;
            }
        }

        return false;
    }
}
