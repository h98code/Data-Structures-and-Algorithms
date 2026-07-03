package org.Projects.DynamicProgramming.OneDimensionDP;

import java.util.Arrays;

public class NinjasTraining {

    public int ninjaTraining(int[][] matrix) {
//        return helper(matrix, matrix.length, -1);

//        int[][] dp = new int[matrix.length + 1][4];
//        for(int[] row : dp) {
//            Arrays.fill(row, -1);
//        }
//
//        return helper(matrix, matrix.length, 3, dp);

        return helper_itr(matrix);
    }

    private int helper_itr(int[][] matrix) {

        int[][] dp = new int[matrix.length + 1][4];

        for(int i=1; i<=matrix.length; i++) {
            for(int j=0; j<4; j++) {

                int temp = 0;

                for(int ptr = 0; ptr < 3; ptr++) {
                    if(ptr != j) {
                        temp = Math.max(temp, matrix[i - 1][ptr] + dp[i - 1][ptr]);
                    }
                }

                dp[i][j] = temp;

            }
        }

        return dp[matrix.length][3];
    }


    // TC = O(3^N) as there are 3 choices for every node of the recursion tree and the height of the tree is N
    // SC = O(N) as height of the recursion tree is N
    private int helper(int[][] a, int n, int actIndex) {
        if(n == 0)
            return 0;

        int ans = 0;

        for(int i=0; i<3; i++) {
            if(i != actIndex) {
                ans = Math.max(ans, a[n - 1][i] + helper(a, n - 1, i));
            }
        }

        return ans;
    }

    // TC = O(N*3) as there are N*3 states and we are calculating each state only once
    // SC = O(N) + O(N*3) ~ O(N) as height of the recursion tree is N and we are using a 2D array of size N*3
    private int helper(int[][] a, int n, int actIndex, int[][] dp) {
        if(n == 0)
            return 0;

        if(dp[n][actIndex] != -1)
            return dp[n][actIndex];

        int ans = 0;

        for(int i=0; i<3; i++) {
            if(i != actIndex) {
                ans = Math.max(ans, a[n - 1][i] + helper(a, n - 1, i, dp));
            }
        }

        return dp[n][actIndex] = ans;
    }
}
