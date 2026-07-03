package org.Projects.Arrays;

public class FindDuplicates1ToN {

    // TC = O(N)
    // SC = O(1)
    public int findDuplicate(int[] nums) {
        // for loop and check
        // sorting linear check
        //         binary check
        // use map
        // modify nums to store freq
        // cycle detection algorithm

        int f = 0, s = 0;

        do {
            f = nums[nums[f]];
            s = nums[s];
        } while (nums[f] != nums[s]);

        s = 0;

        while(nums[f] != nums[s]) {
            f = nums[f];
            s = nums[s];
        }

        return nums[f];
    }
}
