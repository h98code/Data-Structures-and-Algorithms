package org.Projects.DynamicProgramming;

import java.util.Arrays;

public class PartitionWithAGivenDiff {

    // TC = O(2^N)
    // SC = O(N) recursion depth
    public int countPartitions(int n, int diff, int[] arr) {
        int sum = 0;
        for(int el : arr)
            sum += el;

        if(((sum - diff) & 1) == 1)
            return 0;

        return helper(arr, n, (sum-diff)/2);
    }

    //construct a subset and returns the number of subsets that sum to T
    private int helper(int[] arr, int n, int T){
        if(n == 0){
            return T == 0 ? 1 : 0;
        }

        if(arr[n - 1] > T)
            return helper(arr, n - 1, T);

        return helper(arr, n - 1, T) + helper(arr, n - 1, T - arr[n - 1]);
    }

    //============================================================================
    // memoized
    // TC = O(N*T) where T is (totalSum +- diff) / 2
    // SC = O(N*T)
    public int countPartitions_mem(int n, int diff, int[] arr) {
        int sum = 0;
        for(int el : arr)
            sum += el;

        if(diff > sum)
            return 0;

        if(((sum - diff) & 1) == 1)
            return 0;

        int T = (sum - diff)/2;
        int[][] dp = new int[n + 1][T + 1];

        for(int i=0; i<dp.length; i++)
            Arrays.fill(dp[i], -1);

        return helper(arr, n, T, dp);
    }

    private int helper(int[] arr, int n, int T, int[][] dp){
        if(n == 0){
            return T == 0 ? 1 : 0;
        }

        if(dp[n][T] != -1)
            return dp[n][T];

        if(arr[n - 1] > T)
            return dp[n][T] = helper(arr,n - 1, T, dp) % 1000000007;

        return dp[n][T] = (helper(arr, n - 1, T, dp) + helper(arr, n - 1, T - arr[n - 1], dp)) % 1000000007;
    }

    // =============================================================================
        //iterative
    // TC = O(N*T)
    // SC = O(N*T)
    public int countPartitions_itr(int n, int diff, int[] arr) {
        int sum = 0;
        for(int el : arr)
            sum += el;

        if(diff > sum)
            return 0;

        if(((sum - diff) & 1) == 1)
            return 0;

        int T = (sum - diff)/2;
        int[][] dp = new int[n + 1][T + 1];

        dp[0][0] = 1;

        for(int i=1; i<n+1; i++){
            for(int j=0; j<T + 1; j++){
                if(arr[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    int exclude = dp[i-1][j];
                    int include = dp[i-1][j - arr[i - 1]];

                    dp[i][j] =  (exclude + include) % 1000000007;
                }
            }
        }

        return dp[n][T];
    }
}
