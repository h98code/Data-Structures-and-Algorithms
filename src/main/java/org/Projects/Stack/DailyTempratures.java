package org.Projects.Stack;

import java.util.Stack;

public class DailyTempratures {

    // TC = O(N)
    // SC = O(N)
    public int[] dailyTemperatures(int[] temp) {
        // calculate nge index

        Stack<Integer> stk = new Stack<>();
        int[] nge = new int[temp.length];

        for(int i=temp.length - 1; i >= 0; i--) {
            while(!stk.isEmpty() && temp[stk.peek()] <= temp[i]) {
                stk.pop();
            }

            nge[i] = stk.isEmpty() ? 0 : stk.peek() - i;

            stk.push(i);
        }

        return nge;
    }
}
