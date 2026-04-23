package org.Projects.Hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmonicSubseq {
    public int findLHS(int[] nums) {
        //store the freq in a map
        // check if consecutive element is present or not
        //sum of their frequencies is the answer.

        int ans = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        for(int el : nums)
            mp.put(el, mp.getOrDefault(el, 0) + 1);

        for(Map.Entry<Integer, Integer> it : mp.entrySet()){
            int key = it.getKey();

            if(mp.containsKey(key + 1)){
                ans = Math.max(ans, mp.get(key + 1) + it.getValue());
            }
        }

        return ans;
    }
}
