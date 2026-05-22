package org.Projects.BinarySearch;

public class SearchIn2DMatirx {

    // TC  = O(log(m*n))
    // SC = O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int st = 0, end = rows*cols - 1;

        while(st <= end) {
            int mid = st + (end - st)/2;

            int r = mid / cols;
            int c = mid % cols;

            if(matrix[r][c] == target)
                return true;
            else if(matrix[r][c] > target) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return false;
    }
}
