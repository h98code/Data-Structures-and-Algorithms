package org.Projects.Recursion;

import java.util.Arrays;

public class ClimbingStairs {

    //TC = O(N) --> FIBONNACI SERIES
    //SC = O(N) --> recursive stack space.
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
}
