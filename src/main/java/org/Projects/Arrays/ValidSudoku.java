package org.Projects.Arrays;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            boolean row = isDuplicateInRow(board, i);
            boolean col = isDuplicateInCol(board, i);
            boolean sq = isDuplicateInSq(board, i);

            if(row || col || sq) return false;
        }

        return true;
    }

    public boolean isDuplicateInRow(char[][] b, int row) {
        Set<Character> s = new HashSet<>();

        for(int i=0; i<9; i++) {
            if(s.contains(b[row][i])){
                return true;
            }

            if(b[row][i] != '.'){
                s.add(b[row][i]);
            }
        }

        return false;
    }

    public boolean isDuplicateInCol(char[][] b, int col) {
        Set<Character> s = new HashSet<>();

        for(int i=0; i<9; i++) {
            if(s.contains(b[i][col])){
                return true;
            }

            if(b[i][col] != '.'){
                s.add(b[i][col]);
            }
        }

        return false;
    }

    public boolean isDuplicateInSq(char[][] b, int num) {
        Set<Character> s = new HashSet<>();

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(s.contains(b[((num / 3) * 3) + i][((num % 3) * 3) + j])) {
                    return true;
                }

                if(b[((num / 3) * 3) + i][((num % 3) * 3) + j] != '.') {
                    s.add(b[((num / 3) * 3) + i][((num % 3) * 3) + j]);
                }
            }
        }

        return false;
    }
}
