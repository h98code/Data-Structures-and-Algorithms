package org.Projects.SlidingWindow.FixedSizeWindow;

import java.util.HashMap;
import java.util.Map;

public class CountGoodSubstrings {

    // TC = O(N)
    // SC = O(N)
    public int countGoodSubstrings(String s) {
        int k = 3;
        return helper(s, k);
    }

    private int helper(String s, int k){
        if(s.length() < k)
            return 0;

        int ans = 0;

        Map<Character, Integer> mp = new HashMap<>();

        for(int i=0; i<s.length(); i++){

            //adding the character in the sliding window
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            if(i >= k - 1){
                if(i >= k){ // removing the leftmost element of the window
                    char lastCh = s.charAt(i - k);
                    mp.put(lastCh, mp.get(lastCh) - 1);

                    if(mp.get(lastCh) == 0) mp.remove(lastCh);
                }

                //checking the condition of the current window
                if(mp.size() == k)
                    ans++;
            }
        }

        return ans;
    }
}
