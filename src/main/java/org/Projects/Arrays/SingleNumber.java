package org.Projects.Arrays;

public class SingleNumber {


    // TC = O(N)
    // SC = O(1)
    public int singleNumber(int[] nums) {

        int ans = 0;

        for(int el : nums){
            ans = ans ^ el;
        }

        return ans;
    }
}
