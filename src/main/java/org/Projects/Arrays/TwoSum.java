package org.Projects.Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // TC = O(N)
    // SC = O(N)
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(mp.containsKey(target - nums[i])){
                return new int[]{i, mp.get(target - nums[i])};
            }

            mp.put(nums[i], i);
        }

        return new int[]{};
    }
}
