package org.Projects.DynamicProgramming;

import java.util.Arrays;

public class RodCuttingProblem {
    public int RodCutting(int price[], int n) {
        return helper(price, n, n);
    }

    private int helper(int val[], int l, int N){
        if(N == 0)
            return 0;

        if(l == 0)
            return 0;

        if(l > N){
            return helper(val, l - 1, N);
        }else{
            return Math.max(helper(val, l - 1, N), val[l - 1] + helper(val, l, N - l));
        }
    }

    //============================================================================
    public int RodCutting_mem(int price[], int n) {
        int[][] dp = new int[n + 1][n + 1];

        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        int len[] = new int[n];
        for(int i=0; i<n; i++)
            len[i] = i + 1;

        return helper(price, len, n, n, dp);
    }

    private int helper(int[] val, int[] len, int n, int L, int[][] dp){
        if(L == 0)
            return 0;

        if(n == 0)
            return 0;

        if(dp[n][L] != -1)
            return dp[n][L];

        if(len[n - 1] > L)
            return dp[n][L] = helper(val, len, n - 1, L, dp);

        return dp[n][L] = Math.max( helper(val, len, n - 1, L, dp),
                helper(val, len, n, L - len[n - 1], dp) + val[n - 1]
        );
    }

    //====================================================================
    public int RodCutting_itr(int price[], int n) {
        int[][] dp = new int[n + 1][n + 1];

        int len[] = new int[n];
        for(int i=0; i<n; i++)
            len[i] = i + 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(len[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - len[i - 1]] + price[i - 1]);
                }
            }
        }

        return dp[n][n];
    }
}
