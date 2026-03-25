package org.Projects.DynamicProgramming;

import java.util.Arrays;

public class EqualSumPartition {

    //recursive solution
    //TC = O(2^N) for every element we have 2 choices
    //SC = O(N) recursion depth
    public boolean equalPartition(int n, int[] arr) {
        int sum = 0;

        for(int el : arr) sum += el;

        if((sum & 1) == 1)
            return false;

        return helper(arr, n, sum/2);
    }

    private boolean helper(int[] arr, int n, int T){
        if(T == 0)
            return true;

        if(n == 0)
            return false;

        if(arr[n - 1] > T)
            return helper(arr, n - 1, T);

        return helper(arr, n - 1, T) || helper(arr, n - 1, T - arr[n - 1]);
    }

    // ==========================================================
    // memoized solution :
    //TC = O(N*T)
    //SC = O(N*T) matrix storage
    public boolean equalPartition_mem(int n, int[] arr) {
        int sum = 0;

        for(int el : arr) sum += el;

        if((sum & 1) == 1)
            return false;

        int[][] dp = new int[n + 1][sum/2 + 1];

        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(arr, n, sum/2, dp) == 1;
    }

    private int helper(int[] arr, int n, int T, int[][] dp)
    {
        if(T == 0)
            return 1;

        if(n == 0)
            return 0;

        if(dp[n][T] != - 1)
            return dp[n][T];

        if(arr[n - 1] > T)
            return dp[n][T] = helper(arr, n - 1, T, dp);
        else{
            return dp[n][T] = ((helper(arr, n - 1, T, dp) == 1) || (helper(arr, n - 1, T - arr[n - 1], dp) == 1)) ? 1 : 0;
        }
    }

    //=========================================================
    //iterative solution
    //TC = O(N*T)
    //SC = O(N*T) matrix storage
    public boolean equalPartition_itr(int n, int[] arr) {
        int sum = 0;

        for(int el : arr) sum += el;

        if((sum & 1) == 1)
            return false;

        boolean[][] dp = new boolean[n + 1][sum/2 + 1];

        for(int row = 0; row < n + 1; row++)
            dp[row][0] = true;

        int T = sum / 2;

        for(int i=1; i<n+1; i++){
            for(int j=1; j<T+1; j++){
                if(arr[i-1] > j){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] || dp[i -1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][T];
    }
}
