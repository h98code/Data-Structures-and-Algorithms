package org.Projects.DynamicProgramming.OneDimensionDP;

public class HouseRobber {

    // TC = O(N)
    // SC = O(N)
    public int rob(int[] nums) {
        int dp[] = new int[nums.length + 1];

        dp[1] = nums[0];

        for(int i=2; i<=nums.length; i++){
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length];
    }

    // space optimised
    public int rob_itr(int[] nums) {
        int prev = 0, mid = nums[0];

        for(int i=2; i<=nums.length; i++){
            int curr = Math.max(nums[i - 1] + prev, mid);
            prev = mid;
            mid = curr;
        }

        return mid;
    }
}
