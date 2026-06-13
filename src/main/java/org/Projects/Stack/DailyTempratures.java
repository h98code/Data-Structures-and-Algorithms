package org.Projects.Stack;

import java.util.Stack;

public class DailyTempratures {

    // TC = O(N)
    // SC = O(N)
    public int[] dailyTemperatures(int[] tempratures) {

        // stack to store the index of the next greater element
        Stack<Integer> stk = new Stack<>();

        int[] ngei = new int[tempratures.length];
        int ptr = ngei.length - 1;

        for(int i=tempratures.length - 1; i>=0; i--){

            int curr = tempratures[i];

            while(!stk.isEmpty() && tempratures[stk.peek()] <= curr)
                stk.pop();

            ngei[ptr--] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }

        for(int i=0; i<ngei.length; i++){
            if(ngei[i] == -1) {
                ngei[i] = 0;
            } else {
                ngei[i] -= i;
            }
        }

        return ngei;
    }
}
