package org.Projects.Strings;

public class isPlaindrome {

    public boolean isPalindrome(String s) {
        int st = 0, end = s.length() - 1;

        while(st < end) {
            if(!isAlphaNumeric(s.charAt(st))) {
                st++;
                continue;
            }

            if(!isAlphaNumeric(s.charAt(end))) {
                end--;
                continue;
            }

            if(!isMatch(s.charAt(st), s.charAt(end))) {
                return false;
            }

            st++;
            end--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char ch) {
        if ((ch >= 'a' && ch <= 'z')
                || (ch >= 'A' && ch <= 'Z')
                || (ch >= '0' && ch <= '9')
        ) {
            return true;
        }

        return false;
    }

    private boolean isMatch(char c1, char c2) {

        //converts c1 and c2 from upper case to lower case
        c1 = (c1 >= 'A' && c1 <= 'Z') ? (char)(c1 - 'A' + 'a'): c1;
        c2 = (c2 >= 'A' && c2 <= 'Z') ? (char)(c2 - 'A' + 'a'): c2;

        return c1 == c2;
    }
}
