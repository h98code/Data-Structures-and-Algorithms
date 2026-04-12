package org.Projects.Stack;

import java.util.Stack;

public class AsteroidCollisions {

    // asteroids are moving in +ve and -ve directions, return the final result after all the collisions
    // TC = O(N)
    // SC = O(N) stack space required.
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        boolean isEqual = false;

        for(int el : asteroids){
            if(el < 0){

                isEqual = false;

                // popping the stack elements, if the current element is -ve and magnitude > +ve elements present in stack
                while(!stk.isEmpty() && (stk.peek() > 0 && stk.peek() <= -el)){
                    int topEl = stk.pop();

                    if (topEl == -el){
                        isEqual = true;
                        break;
                    }
                }

                if(stk.isEmpty()){
                    if(!isEqual){
                        stk.push(el);
                    }
                }else{
                    if(!isEqual && (stk.peek() < 0))
                        stk.push(el);
                }

            } else {
                stk.push(el);
            }
        }

        int ans[] = new int[stk.size()];
        int ptr = ans.length - 1;
        while(!stk.isEmpty()){
            ans[ptr--] = stk.pop();
        }

        return ans;
    }
}
