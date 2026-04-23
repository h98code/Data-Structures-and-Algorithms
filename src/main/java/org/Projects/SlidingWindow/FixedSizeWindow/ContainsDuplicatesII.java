package org.Projects.SlidingWindow.FixedSizeWindow;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicatesII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        //create a window of size k + 1
        // then remove an element and add an element and check for the new window.
        //  set to check if the element exists in the window or not

        if(k == 0)
            return false;

        Set<Integer> set = new HashSet<>();

        //we have to create a window of size k + 1

        for(int i=0; i<nums.length; i++){
            if(i > k){
                set.remove(nums[i - k - 1]);
            }

            if(!set.add(nums[i]))
                return true;
        }

        return false;
    }
}
