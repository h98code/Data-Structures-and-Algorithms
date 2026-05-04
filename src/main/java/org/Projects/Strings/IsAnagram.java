package org.Projects.Strings;

public class IsAnagram {

    // TC = O(N + M) travering both the string once
    // SC = O(1) freq map to store the freq of chars of s and check with t, as we are only storing the freq of 26 chars, so it is constant space.
    public boolean isAnagram(String s, String t) {
        int freq[] = new int[26];

        //storing the freq of chars of s in freq
        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);

            freq[ch - 'a']++;
        }

        //checking the stored freq with t
        for(int i = 0; i < t.length(); i++){
            Character ch = t.charAt(i);

            if(freq[ch - 'a'] == 0)
                return false;

            freq[ch - 'a']--;
        }

        // check if all the characters matched in both the strings.
        for(int f : freq){
            if(f != 0)
                return false;
        }

        return true;
    }
}
