package org.Projects.SlidingWindow.VariableSizeWindow;

public class MaximumConsOnesIII {

    // TC = O(N)
    // SC = O(1)


    /* plan
        if 1 is found, just move forward
        if 0 is found then consider the cases :
            if k is 0 then we need to skip the left most 0 and move forward.
            if k is greater than 0 then we can use the current 0 and move forward.

         at each step calculate the max length of the window.
     */

    // edge case : if the given value of k is 0

    public int longestOnes(int[] nums, int k) {
        if(k == nums.length)
            return nums.length;

        int ptr = 0;
        int ans = 0;

        for(int i = 0; i < nums.length; i++){
            if (nums[i] == 0) {
                if (k == 0) {
                    while(ptr <= i) {
                        if (nums[ptr] == 1) ptr++;
                        else {
                            ptr++;
                            k++; //skipping the left most 0
                            break;
                        }
                    }

                    // check if the current 0 can be used after skippping the left most.
                } if (k > 0) {
                    k--;
                }
            }

            ans = Math.max(ans, i - ptr + 1);
        }

        return ans;
    }
}
