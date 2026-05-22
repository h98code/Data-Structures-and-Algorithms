package org.Projects.Strings;

public class LongestCommonPrefix {

    // TC = O(N * lcp length)
    // SC = O(N)
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];

        for(int i=1; i<strs.length; i++){
            ans = lcp(ans, strs[i]);
        }

        return ans;
    }

    private String lcp(String s1, String s2){
        StringBuilder sb = new StringBuilder();

        int l = Math.min(s1.length(), s2.length());

        for(int i=0; i<l; i++){
            if(s1.charAt(i) == s2.charAt(i))
                sb.append(s1.charAt(i));
            else
                break;
        }

        return sb.toString();
    }
}
