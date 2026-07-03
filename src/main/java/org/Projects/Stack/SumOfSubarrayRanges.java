package org.Projects.Stack;

import java.util.Stack;

public class SumOfSubarrayRanges {

    // TC = O(N)
    // SC = o(N)

    // PSE and NSE are used for calculations in one iteration
    // PGE and NGE are used for calculation in one iteration
    public long subArrayRanges(int[] nums) {
        long minimums = calculateMins(nums);
        long maximums = calculateMaxs(nums);

        System.out.println(minimums);
        System.out.println(maximums);


        return maximums - minimums;
    }

    // function to calculate the the number of subarrays an element contributed as minimum
    private long calculateMins(int[] nums) {

        //store the indices of the pse and nse
        Stack<Integer> stk = new Stack<>();
        long ans = 0;

        for(int i=0; i<=nums.length; i++){
            long curr =  (i == nums.length) ? Integer.MIN_VALUE : nums[i];

            while(!stk.isEmpty() && nums[stk.peek()] >= curr) {
                int pseIndex = -1;
                int index = stk.pop();
                int nseIndex = i;

                if(!stk.isEmpty()) pseIndex = stk.peek();

                ans += (long)(index - pseIndex) * (nseIndex - index) * nums[index];
            }

            stk.push(i);
        }

        return ans;
    }

    // function to calculate the the number of subarrays an element contributed as maximum
    private long calculateMaxs(int[] nums) {

        Stack<Integer> stk = new Stack<>();
        long ans = 0;

        for(int i=0; i<=nums.length; i++) {

            long curr = (i == nums.length) ? Integer.MAX_VALUE : nums[i];

            while(!stk.isEmpty() && nums[stk.peek()] <= curr) {
                int pgeIndex = -1;
                int index = stk.pop();
                int ngeIndex = i;

                if(!stk.isEmpty()) pgeIndex = stk.peek();

                ans += (long)(index - pgeIndex) * (ngeIndex - index) * nums[index];
            }

            stk.push(i);
        }

        return ans;
    }
}
