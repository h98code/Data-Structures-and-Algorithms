package org.Projects.DynamicProgramming;

import java.util.Arrays;

public class SubsetSumEqulaT {

    //TC = O(2^N) as for every element we have 2 choices
    //SC = O(N) recursion depth
    public boolean isSubsetSum(int[] arr, int target) {
        return helper(arr, arr.length, target);
    }

    private boolean helper(int[] a, int n, int t){
        // base conditions
        if(t == 0)
            return true;

        if(n == 0)
            return false;

        //not include if the current element is > t
        if(a[n - 1] > t){
            return helper(a, n - 1, t);
        }else{
            return helper(a, n - 1, t) || helper(a, n - 1, t - a[n-1]);
        }
    }

    // ===============================================================

    //memoized solution
    //TC  = O(N*T)
    //SC = O(N*T) storage matrix + O(N) recursion depth = O(N*T)9
    public boolean isSubsetSum_mem(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];

        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(arr, n, target, dp) == 1;
    }

    private int helper(int[] a, int n, int t, int[][] dp){
        // base conditions
        if(t == 0)
            return 1;

        if(n == 0)
            return 0;

        if(dp[n][t] != -1){
            return dp[n][t];
        }

        //not include if the current element is > t
        if(a[n - 1] > t){
            return dp[n][t] = helper(a, n - 1, t, dp);
        }else{
            return dp[n][t] = (helper(a, n - 1, t, dp) == 1 || helper(a, n - 1, t - a[n-1], dp) == 1) ? 1 : 0;
        }
    }


    // =================================================================================
    //iterative solution
    //TC = O(N*T)
    //SC = O(N*T) storage matrix
    public boolean isSubsetSum_itr(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // initializing the first row, where the target will be 0
        for(int row = 0; row < n + 1; row++){
            dp[row][0] = true;
        }

        //replace n with i and target with j
        for(int i=1; i<n+1; i++){
            for(int j=1; j<target+1; j++){
                if(arr[i - 1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][target];
    }
}
