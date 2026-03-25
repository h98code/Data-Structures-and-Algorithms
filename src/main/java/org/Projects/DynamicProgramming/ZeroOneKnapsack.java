package org.Projects.DynamicProgramming;

import java.util.Arrays;

public class ZeroOneKnapsack {
    //recursive solution
    // TC = O(2^N) as for every item, we have 2 choices
    // SC = O(N) recursion depth
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        //base condition
        if(n == 0 || W == 0)
            return 0;

        if(wt[n - 1] > W)
            return knapsack01(wt, val, n - 1, W);

        return Math.max(knapsack01(wt, val, n-1, W - wt[n-1]) + val[n-1], knapsack01(wt, val, n-1, W));
    }

    //=====================================================
    //memoized solution :

    //TC = O(N^2)
    //SC = O(N^2) storage matrix
    public int knapsack01_mem(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        //filling all the values of the matrix as -1;
        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i], -1);
        }

        return ksHelper(wt, val, n, W, dp);
    }

    public int ksHelper(int[]wt, int[] val, int n, int W, int[][] dp){
        if(n == 0 || W == 0)
            return dp[n][W] = 0;

        if(dp[n][W] != -1)
            return dp[n][W];

        if(wt[n-1] > W){
            return dp[n][W] = ksHelper(wt, val, n - 1, W, dp);
        }

        return dp[n][W] = Math.max(ksHelper(wt, val, n -1 , W - wt[n - 1], dp) + val[n - 1],
                ksHelper(wt, val, n - 1, W, dp));
    }

    // ================================================================
    //iterative :
    //TC = O(N^2)
    //SC = O(N^2)  // if we carefully observe, we only need the previous row of the matrix to calculate the current row, so we can optimize the space complexity to O(N) by using a single array to store the previous row values and updating it in place for the current row.
    public int knapsack01_itr(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        for(int i=1; i<n + 1; i++){
            for(int j=1; j<W + 1; j++){
                if(wt[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else{
                    dp[i][j] = Math.max(dp[i - 1][j - wt[i-1]] + val[i-1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][W];
    }

    // =================================================================
    //space optimized iterative :
    //TC = O(N^2)
    //SC = O(N^2)
    public int knapsack01_itr_space(int[] wt, int[] val, int n, int W) {
        int dp[] = new int[W + 1];
        int row[] = new int[W + 1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                if(wt[i - 1] > j)
                    dp[j] = row[j];
                else{
                    dp[j] = Math.max(row[j - wt[i-1]] + val[i-1], row[j]);
                }
            }

            row = Arrays.copyOf(dp, W + 1);
        }

        return dp[W];
    }

    // ================================================================================
    //single row space optimized iterative :
    public int knapsack01_itr_sapce_single(int[] wt, int[] val, int n, int W) {
        int row[] = new int[W + 1];

        for(int i=1; i<n+1; i++){
            for(int j=W; j>0; j--){ //reverse iteration to fill up the rows.
                if(wt[i - 1] > j)
                    row[j] = row[j];
                else{
                    row[j] = Math.max(row[j - wt[i-1]] + val[i-1], row[j]);
                }
            }
        }

        return row[W];
    }
}
