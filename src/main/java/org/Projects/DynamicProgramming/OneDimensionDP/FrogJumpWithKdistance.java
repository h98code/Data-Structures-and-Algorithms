package org.Projects.DynamicProgramming.OneDimensionDP;

import java.util.Arrays;

public class FrogJumpWithKdistance {

    public int frogJump(int[] heights, int k) {
//        return helper(heights, k, 0);

        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        return helper_mem(heights, k, 0, dp);
    }

    // TC = O(K^N) as every level of recursion tree will have K nodes and the depth will be N
    // SC = O(N) the depth of the recursion tree.
    private int helper(int[] a, int k, int index) {
        // base case
        if(index == a.length - 1) return 0;

        int ans = Integer.MAX_VALUE;

        for(int i=1; i<=k; i++) {
            if(index + i < a.length) {
                ans = Math.min(ans, Math.abs(a[index] - a[index + i]) + helper(a, k, index + i));
            }
        }

        return ans;
    }

    // TC = O(N * K) n number of states and k work per state
    // SC = O(N) dp array
    private int helper_mem(int[] a, int k, int index, int[] dp) {
        // base case
        if(index == a.length - 1) return dp[index] = 0;

        if(dp[index] != -1) return dp[index];

        int ans = Integer.MAX_VALUE;

        for(int i=1; i<=k; i++) {
            if(index + i < a.length) {
                ans = Math.min(ans, Math.abs(a[index] - a[index + i]) + helper_mem(a, k, index + i, dp));
            }
        }

        return dp[index] = ans;
    }

    // TC = O(N * K)
    // SC = O(N) dp array, which can be further optimized to O(K)
    public int frogJump_itr(int[] heights, int k) {
        int[] dp = new int[heights.length];

        for(int ind=heights.length - 2; ind>=0; ind--) {

            int ans = Integer.MAX_VALUE;

            for(int i=1; i<=k; i++) {
                if(ind + i < heights.length) {
                    ans = Math.min(ans, Math.abs(heights[ind] - heights[ind + i]) + dp[ind + i]);
                }
            }

            dp[ind] = ans;
        }

        return dp[0];
    }
}
