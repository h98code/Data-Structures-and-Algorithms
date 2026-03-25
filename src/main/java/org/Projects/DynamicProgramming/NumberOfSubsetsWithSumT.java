package org.Projects.DynamicProgramming;

import java.util.Arrays;

public class NumberOfSubsetsWithSumT {


    //recursive solution
    //TC = O(2^N)
    //SC = O(N) recursion depth
    public int perfectSum(int[] arr, int K) {
        return helper(arr, arr.length , K);
    }

    private int helper(int[] arr, int n, int T){
        if(T == 0)
            return 1;

        if(n == 0)
            return 0;

        if(arr[n - 1] > T)
            return helper(arr, n - 1, T);

        return helper(arr, n - 1, T) + helper(arr, n - 1, T - arr[n - 1]);
    }

    public static final int mod = (int)1e9 + 7;


    // TC = O(N*T)
    // SC = O(N*T) storage matrix + O(N) recursion depth = O(N*T)
    public int perfectSum_mem(int[] arr, int K) {
        int n = arr.length;
        int[][] dp = new int[n + 1][K + 1];

        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(arr, n, K, dp);
    }

    private int helper(int[] arr, int n, int T, int[][] dp){
        if(T == 0)
            return 1;

        if(n == 0)
            return 0;

        if(dp[n][T] != -1)
            return dp[n][T];

        if(arr[n - 1] > T)
            return dp[n][T] = helper(arr, n - 1, T, dp);

        int exclude = helper(arr, n - 1, T, dp) % mod;
        int include = helper(arr, n - 1, T - arr[n - 1], dp) % mod;

        return dp[n][T] = (include + exclude) % mod;
    }
}
