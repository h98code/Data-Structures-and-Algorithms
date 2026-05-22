package org.Projects.BinarySearch;

public class SearchInAMatrixII {

    // TC = O(m + n)
    // SC = O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;

        while(i < matrix.length && j >= 0){
            int el = matrix[i][j];

            if(el == target) {
                return true;
            } else if(el > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
