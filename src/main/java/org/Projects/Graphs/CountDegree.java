package org.Projects.Graphs;

public class CountDegree {

    // TC = O(V^2)
    // SC = O(1)
    public int[] findDegrees(int[][] matrix) {
        int[] ans = new int[matrix.length];

        int v = matrix.length;

        for(int i=0; i<v; i++) {
            int count = 0;

            for(int j=0; j<v; j++){
                if(matrix[i][j] == 1) count++;
            }

            ans[i] = count;
        }

        return ans;
    }
}
