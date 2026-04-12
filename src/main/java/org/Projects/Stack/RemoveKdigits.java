package org.Projects.Stack;

import java.util.Stack;

public class RemoveKdigits {

    // remove k digits from the number such that the new number is the smallest possible
    // TC = O(N) where N is the length of the string
    // SC = O(N) in worst case when the stack contains all the digits of the number
    public String removeKdigits(String num, int k) {

        //storing the length of the string in a variable
        int n = num.length();

        if(k >= n)
            return "0";

        Stack<Character> stk = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = num.charAt(i);

            while(!stk.isEmpty() && (k > 0 && ch < stk.peek())){
                stk.pop();
                k--;
            }

            if(!stk.isEmpty() || ch != '0') {
                stk.push(ch);
            }
        }

        while(!stk.isEmpty() && k > 0){
            stk.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }

        sb.reverse();

        return sb.length() > 0 ? sb.toString() : "0";
    }
}
