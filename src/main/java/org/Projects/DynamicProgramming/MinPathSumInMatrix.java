package org.Projects.DynamicProgramming;

public class MinPathSumInMatrix {

    // recursive solution
    // TC = O(2^(m+n)) for every cell we have 2 choices
    // SC = O(m+n) recursion depth
    // can also think this as a DFS on a matrix graph
    private int helper(int[][] a, int m, int n){
        if(m == 1 && n == 1)
            return a[0][0];

        if(m == 0 || n == 0)
            return Integer.MAX_VALUE;

        return a[m - 1][n - 1] + Math.min( helper(a, m - 1, n), helper(a, m, n - 1) );
    }

    // ================================================================================================

    // mem sol
    // TC =  O(m*n) filling the dp matrix
    // SC = O(m*n) storage matrix + O(m+n) recursion depth = O(m*n)
    private int helper(int[][] a, int m, int n, int[][] dp){
        if(m == 1 && n == 1)
            return a[0][0];

        if(m == 0 || n == 0)
            return Integer.MAX_VALUE;

        if(dp[m][n] != -1)
            return dp[m][n];

        return dp[m][n] = a[m - 1][n - 1] + Math.min( helper(a, m - 1, n, dp), helper(a, m, n - 1, dp) );
    }

    // ===============================================================================================

    // Iterative solution
    // TC = O(m * n)
    // SC = O(m * n)
    public int minPathSum(int[][] grid) {
        // return helper(grid, grid.length, grid[0].length);

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = Integer.MAX_VALUE;
                }else if(i == 1 && j == 1){
                    dp[i][j] = grid[0][0];
                }else {
                    dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    //space optimization can be done by using a single array of size n + 1 and updating it in place as we iterate through the grid.
}
