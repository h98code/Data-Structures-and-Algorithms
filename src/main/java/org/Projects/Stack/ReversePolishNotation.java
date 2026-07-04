package org.Projects.Stack;

import java.util.Stack;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();

        for(String str : tokens) {
            if(isOperation(str)) { // if the current string is an operator
                int sec = stk.pop();
                int first = stk.pop();

                char op = str.charAt(0);

                if(op == '+') {
                    stk.push(sec + first);
                } else if(op == '-') {
                    stk.push(first - sec);
                } else if (op == '*') {
                    stk.push(sec * first);
                } else {
                    stk.push(first / sec);
                }
            } else {
                stk.push(Integer.parseInt(str));
            }
        }

        return stk.pop();
    }

    private boolean isOperation(String str) {
        String operations = "*+-/";

        for(int i=0; i<operations.length(); i++) {
            if((str.length() == 1) && (operations.charAt(i) == str.charAt(0))) {
                return true;
            }
        }

        return false;
    }
}
