package org.Projects.Arrays;

public class MaximumConsecutiveOnes {

    // TC = O(N)
    // SC = O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int count = 0;

        for(int el : nums){
            if(el == 1){
                count++;
            }else{
                count = 0;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}
