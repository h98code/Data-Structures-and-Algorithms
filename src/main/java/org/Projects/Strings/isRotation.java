package org.Projects.Strings;

public class isRotation {

    // TC = O(n^2) cause of substring and equals method, SC = O(n) for creating the new string goal + goal
    // SC = O(N)
    public boolean rotateString(String s, String goal) {

        if(goal.length() != s.length())
            return false;

        goal = goal + goal;

        int gl = goal.length();
        int sl = s.length();

        for(int i=0; i<gl - sl; i++){
            if(goal.substring(i, i + sl).equals(s)) return true;
        }

        return false;
    }

}
