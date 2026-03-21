package org.Projects.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsGeneration {

    //generates the power set of the given array.
    //given = all the elements of the array are unique.
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(0, nums, ans, subset);

        return ans;
    }

    // TC = O(2^n), as the decision tree will have the depth n, with 2 choices at every decision node.
    // SC = O(N), as the maximum depth of the recursion will be n, and we are using a subset list to store the current subset, which can have at most n elements.
    public void helper(int index, int[] nums, List<List<Integer>> ans, List<Integer> subset){
        if(index == nums.length){
            ans.add(new ArrayList(subset));
            return;
        }

        //if the current element is not included
        helper(index + 1, nums, ans, subset);

        //if the current element is included in the subset
        subset.add(nums[index]);
        helper(index + 1, nums, ans, subset);
        subset.remove(subset.size() - 1);
    }
}
