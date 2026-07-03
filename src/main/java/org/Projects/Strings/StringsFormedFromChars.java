package org.Projects.Strings;

import java.util.HashMap;
import java.util.Map;

public class StringsFormedFromChars {

    public int countCharacters(String[] words, String chars) {

        int ans = 0;

        Map<Character, Integer> mp = new HashMap<>();

        for(int i=0; i<chars.length(); i++) {
            char ch = chars.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> word_mp = new HashMap<>();
        for(String word : words) {

            boolean valid = true;
            for(int i=0; i<word.length(); i++) {
                char ch = word.charAt(i);
                word_mp.put(ch, word_mp.getOrDefault(ch, 0) + 1);

                if(!mp.containsKey(ch) || word_mp.get(ch) > mp.get(ch)) {
                    valid = false;
                    break;
                }
            }

            word_mp.clear();

            if(valid) {
                ans += word.length();
            }
        }

        return ans;
    }
}
