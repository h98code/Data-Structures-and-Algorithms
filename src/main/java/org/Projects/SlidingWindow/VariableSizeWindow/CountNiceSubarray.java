package org.Projects.SlidingWindow.VariableSizeWindow;

import java.util.ArrayList;
import java.util.List;

public class CountNiceSubarray {


    // TC = O(N) as the array is visited once
    // SC = O(N) as we are storing the indices of odd numbers in the list

    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int left = 0, ptr = 0;
        int ans = 0;

        // list to store the index of the odd numbers encountered
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if((nums[i] & 1) == 1){
                count++;
                list.add(i);
            }

            while(count > k){
                if((nums[left] & 1) == 1){
                    count--;
                    ptr++;
                }

                left++;
            }

            if(count == k)
                ans += (list.get(ptr) - left + 1); // number of subarrays will be, the next odd number index - left + 1, as the subarray can start from any index between left and the next odd number index
        }

        return ans;
    }
}
