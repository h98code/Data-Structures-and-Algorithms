package org.Projects.Stack;

import java.util.Stack;

public class BalancedParanthesis {

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);

            if(curr == '(' || curr == '[' || curr == '{') {
                stk.push(curr);
            } else {
                if(stk.isEmpty()) {
                    return false;
                }

                char top = stk.peek();

                if(isMatch(curr, top)) {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }

        if(stk.isEmpty()) return true;

        return false;
    }

    private boolean isMatch(char curr, char top) {
        if(curr == ')' && top == '(') {
            return true;
        } else if (curr == ']' && top == '[') {
            return true;
        } else if (curr == '}' && top == '{') {
            return true;
        }

        return false;
    }
}
