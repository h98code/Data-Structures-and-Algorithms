package org.Projects.Strings;


import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public int romanToInt(String s) {

        Map<Character, Integer> mp = new HashMap<>();
        int ans = 0;

        // populating the map with the values
        populateMap(mp);

        for(int i = 0; i < s.length() - 1; i++){
            char current = s.charAt(i);
            char next = s.charAt(i + 1);

            if ((current == 'I' && (next == 'V' || next == 'X')) ||
                    (current == 'X' && (next == 'L' || next == 'C')) ||
                    (current == 'C' && (next == 'D' || next == 'M'))
            ) {
                ans -= mp.get(current);
            } else {
                ans += mp.get(current);
            }
        }

        //adding the value of the last character
        ans += mp.get(s.charAt(s.length() - 1));

        return ans;
    }

    private void populateMap(Map<Character, Integer> mp) {
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
    }
}
