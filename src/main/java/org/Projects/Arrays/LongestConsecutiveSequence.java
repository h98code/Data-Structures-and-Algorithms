package org.Projects.Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int ans = 0;

        for(int el : nums) {
            s.add(el);
        }

        for(Integer key : s) {
            if (!s.contains(key + 1)) {

                int count = 0;

                while (s.contains(key)) {
                    count++;
                    key--;
                }

                ans = Math.max(ans, count);

            }
        }
            return ans;
    }
}
