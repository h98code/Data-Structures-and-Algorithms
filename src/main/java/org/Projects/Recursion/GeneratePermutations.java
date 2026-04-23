package org.Projects.Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeneratePermutations {

    // TC = O(n * n!)
    // SC = O(n) for the recursion stack and temp list
    public List<List<Integer>> permute(int[] nums) {
        // store the used values in a set
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        helper(nums, set, ans, temp);
        return ans;
    }

    private void helper(int[] a, Set<Integer> set, List<List<Integer>> ans, List<Integer> temp){
        //base condition
        if(set.size() == a.length){
            ans.add(new ArrayList<>(temp));
        }

        for(int i=0; i<a.length; i++){
            if(set.add(a[i])){
                temp.add(a[i]);
                helper(a, set, ans, temp);
                temp.remove(temp.size() - 1);
                set.remove(a[i]);
            }
        }
    }
}
