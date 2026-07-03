package org.Projects.DynamicProgramming.TwoDimensionalDP;

import java.util.Arrays;

public class GridUniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

//        return helper(m, n, dp);

        return MathsSol(m, n);
    }

    // TC = O(min (m, n)
    //sc = O(1)
    // we can move m - 1 moves down and n - 1 moves right
    // total moves = m + n - 2, out of these moves, we can place D downward moves in any order
    // becomes a combinatorial problem, we can use the formula nCr = n! / (r! * (n - r)!)
    private int MathsSol(int rows, int cols) {
        long ans = 1;
        int r = Math.min(rows, cols);
        r -= 1;
        int n = rows + cols - 2;

        for(int i=1; i<=r; i++) {
            ans *= (n - r + i);
            ans /= i;
        }

        return (int)ans;
    }

    // TC = O(m * n)
    // SC = O(m * n) for the dp array + O(max(m , n)) for the recursion stack
    public int helper(int m, int n, int[][] dp) {
        if(m == 1 || n == 1) {
            return 1;
        }

        if(dp[m][n] != -1) return dp[m][n];

        return dp[m][n] = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}
