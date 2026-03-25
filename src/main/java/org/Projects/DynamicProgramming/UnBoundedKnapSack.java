package org.Projects.DynamicProgramming;

import java.util.Arrays;

public class UnBoundedKnapSack {

    // TC = O(N*W) filling the dp matrix
    // SC = O(N*W) storage matrix + O(N) recursion depth = O(N*W)
    public int unboundedKnapsack_mem(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        for(int i=0; i<dp.length; i++)
            Arrays.fill(dp[i], -1);

        return helper(wt, val, n, W, dp);
    }

    private int helper(int[] wt, int[] val, int n, int W, int[][] dp){
        if(n == 0)
            return 0;

        if(W == 0)
            return 0;

        if(dp[n][W] != -1)
            return dp[n][W];

        if(wt[n - 1] > W)
            return dp[n][W] = helper(wt, val, n - 1, W, dp);

        return dp[n][W] = Math.max(helper(wt, val, n - 1, W, dp),
                helper(wt, val, n, W - wt[n - 1], dp) + val[n - 1]);
    }

    // ==========================================================
    // TC = O(N*W) filling the dp matrix
    // SC = O(N*W) storage matrix
    public int unboundedKnapsack_itr(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                if(wt[i - 1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i][j - wt[i - 1]]);
                }
            }
        }

        return dp[n][W];
    }

    //=======================================================================
        // TC = O(N*W) filling the dp array
        // SC = O(W) storage array
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int[] dp = new int[W + 1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                if(wt[i - 1] <= j){
                    dp[j] = Math.max(dp[j], val[i - 1] + dp[j - wt[i - 1]]);
                }
            }
        }

        return dp[W];
    }
}
