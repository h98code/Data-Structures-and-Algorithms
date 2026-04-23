package org.Projects.DynamicProgramming.LIS;

public class LongestIncreasingSubSeq {

    // TC = O(2 ^ N) pick, non pick algo
    // SC = O(N) recursion depth
    public int LIS(int[] nums) {

        // if the element is smaller or equal to the prev selected element
        // --> ignore the current element

        // pick and non pick.
        return helper(nums, nums.length, Integer.MAX_VALUE);
    }

    private int helper(int[] a, int n, int next){
        if(n == 0)
            return 0;

        if(a[n - 1] >= next)
            return helper(a, n - 1, next);

        return Math.max(1 + helper(a, n - 1, a[n - 1]), helper(a, n - 1, next));
    }


}
