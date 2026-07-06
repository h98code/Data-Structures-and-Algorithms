package org.Projects.Strings;

import java.util.*;

public class GroupAnagrams {

    // TC = O(N*M) as we are using a constant space freq map
    // SC = O(sum of lengths of all the strings | total number of chars in a string)
    public List<List<String>> groupAnagrams_freqMap(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();

        for(String str : strs) {
            int[] fr = new int[26];

            for(int i=0; i<str.length(); i++){
                fr[str.charAt(i) - 'a']++;
            }

            String key = Arrays.toString(fr);

            if(mp.containsKey(key)) {
                mp.get(key).add(str);
            } else {
                mp.put(key, new ArrayList<>(List.of(str)));
            }
        }

        for(List<String> values : mp.values()){
            ans.add(values);
        }

        return ans;
    }

    // TC = O(N* m log m) sorting every string and storing them in the map
    // SC = O(sum of length of all the strings)
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();

        for(String str : strs) {
            //sort the current string
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String ss = new String(s);

            if(mp.containsKey(ss)) { // comparing 2 strings
                mp.get(ss).add(str);
            } else {
                mp.put(ss, new ArrayList<String>(List.of(str)));
            }
        }

        for(List<String> value : mp.values()) {
            ans.add(value);
        }

        return ans;
    }
}
