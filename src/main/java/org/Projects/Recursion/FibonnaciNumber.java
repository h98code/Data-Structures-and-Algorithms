package org.Projects.Recursion;

import java.util.Arrays;


public class FibonnaciNumber {// fucntion to calculate the nth fibonnaci number

    // TC = O(N)
    // SC = O(N) recursive stack space.
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return fibHelper(n, dp);
    }

    private int fibHelper(int n, int[] dp){
        if(dp[n] != -1)
            return dp[n];

        if(n <= 1)
            return n;

        return dp[n] = fibHelper(n - 1, dp) + fibHelper(n - 2, dp);
    }
}
