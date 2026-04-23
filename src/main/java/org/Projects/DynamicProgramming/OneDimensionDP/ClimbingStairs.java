package org.Projects.DynamicProgramming.OneDimensionDP;

import java.util.Arrays;

public class ClimbingStairs {

    // memoized
    // TC = O(N) each state is solved once
    // SC = O(N) recursion depth
    public int climbStairs(int n) {
        int []dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return climbStairsHelper(n, dp);
    }

    private int climbStairsHelper(int n, int[] dp){
        if(dp[n] != -1)
            return dp[n];

        if(n <= 2)
            return n;

        return dp[n] = climbStairsHelper(n - 1, dp) + climbStairsHelper(n - 2, dp);
    }

    // iterative DP
    // TC = O(N) each state solved once
    // SC = O(N) storage array
    public int climbStairs_itr(int n) {
        int[] dp = new int[n + 1];

        if(n <= 2) return n;

        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // space optimised
    // TC = O(N)
    // SC = O(1)
    public int climbStairs_itr2(int n) {
        if(n <= 2)
            return n;

        int leftmost = 1;
        int mid = 2;

        for(int i = 3; i <= n; i++){
            int curr = leftmost + mid;
            leftmost = mid;
            mid = curr;
        }

        return mid;
    }
}
