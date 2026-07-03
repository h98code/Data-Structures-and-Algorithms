package org.Projects.Strings;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBaloons {

    // TC = O(N)
    // SC = O(5)
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> mp = new HashMap<>();

        for(int i=0; i<text.length(); i++){
            char ch = text.charAt(i);

            if(ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch =='n')
                mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        if(mp.size() < 5)
            return 0;

        mp.put('o', mp.get('o') / 2);
        mp.put('l', mp.get('l') / 2);

        int min = text.length();
        for(Integer value : mp.values()) {
            min = Math.min(min, value);
        }

        return min;
    }
}
