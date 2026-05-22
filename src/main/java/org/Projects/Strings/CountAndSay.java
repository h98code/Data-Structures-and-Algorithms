package org.Projects.Strings;

public class CountAndSay {

    // TC = O(2^N) as the lenth of the string can double at every step, SC = O(2^N) for the same reason
    // SC = O(2^N) the largest string can be of the length 2^N.
    public String countAndSay(int n) {
        if(n == 1)
            return "1";

        String prev = countAndSay(n - 1);
        return generate(prev);
    }

    private String generate(String s){
        int l = s.length();

        int ptr = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<l; i++){
            if(s.charAt(i) == s.charAt(ptr)){
                count++;
            } else {
                sb.append(count);
                sb.append(s.charAt(ptr));
                ptr = i;
                count = 1;
            }
        }

        // appending the last character
        sb.append(count);
        sb.append(s.charAt(ptr));

        return sb.toString();
    }
}
