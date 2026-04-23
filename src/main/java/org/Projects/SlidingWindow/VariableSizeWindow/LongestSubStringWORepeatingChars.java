package org.Projects.SlidingWindow.VariableSizeWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWORepeatingChars {

    // TC = O(N) as the array is visited once
    // SC = O(26) considering lower case chars only.
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int ptr = 0;

        Map<Character, Integer> mp = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(mp.containsKey(ch)){
                int index = mp.get(ch);

                if(index >= ptr){
                    ptr = index + 1;
                }
            }

            mp.put(ch, i);
            ans = Math.max(ans, i - ptr + 1);
        }

        return ans;
    }

}
