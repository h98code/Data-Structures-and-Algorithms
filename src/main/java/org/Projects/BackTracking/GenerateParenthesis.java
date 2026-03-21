package org.Projects.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {


    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int co = n, cc = n; // count of open and closed brackets remaining.
        StringBuilder sb = new StringBuilder();
        helper(co, cc, sb, ans);

        return ans;
    }

    //for every ith position, we have 2 options, either we put an open bracket or a closed bracket and then recurse on the solution
    // TC = O(2^(2n)) = O(4^n), as for every position, we have 2 options, and a decision tree of depth 2n.
    // SC =
    public void helper(int co, int cc, StringBuilder sb, List<String> ans){
        if(co == 0 && cc == 0){ // we have used all the brackets and completed the string
            ans.add(sb.toString());
        }

        if(cc < co){ // we cannot have more closed brackets than open brackets at any point in the string, so we return if that happens.
            return;
        }

        if(co > 0){ //adding an open bracket first
            sb.append("(");
            helper(co - 1, cc, sb, ans);
            sb.setLength(sb.length() - 1);
        }

        if(cc > 0){
            sb.append(")");
            helper(co, cc - 1, sb, ans);
            sb.setLength(sb.length() - 1);
        }
    }
}
