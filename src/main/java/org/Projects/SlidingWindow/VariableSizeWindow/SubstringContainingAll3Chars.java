package org.Projects.SlidingWindow.VariableSizeWindow;

import java.util.HashMap;

public class SubstringContainingAll3Chars {

    //hashing approach by tracking the last index amongst a, b, c

    // TC = O(N)
    // SC = O(unique chars present in the string) here 3
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int ans = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            mp.put(ch, i);

            if(mp.size() == 3){

                // fetching the minimum index of a, b, c
                int minIndex = Math.min(mp.get('a'), Math.min(mp.get('b'), mp.get('c')));
                ans += (minIndex + 1);
            }
        }

        return ans;
    }


    // SLIDING WINDOW APPROACH

    /*
        TC = O(N)
        SC = O(3) as we are storing the count of a, b, c in the current window
    */

    public int numberOfSubstrings2(String s) {

        // array to track the frequency of a, b and c.
        int freq[] = new int[3];

        int ans = 0;
        int left = 0;

        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);

            if(!isWindowValid(freq)){
                freq[ch - 'a']++;
            }

            while(isWindowValid(freq)){
                ans += (s.length() - i);
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return ans;
    }

    private boolean isWindowValid(int[] freq){
        if(freq[0] > 0 && freq[1] > 0 && freq[2] > 0)
            return true;

        return false;
    }
}
