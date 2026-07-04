package org.Projects.Stack;

import java.util.Stack;

// only 1  stack is used and the values are manipulated using maths
public class MinStack2 {

    Stack<Long> stk;
    long min;

    public MinStack2() {
        stk = new Stack();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val < min) {
            stk.push(2 * (long)val - min);
            min = val;
        } else {
            stk.push((long)val);
        }
    }

    public void pop() {
        if(min > stk.peek()) {
            min = (2 * min) - stk.peek();
        }

        stk.pop();
    }

    public int top() {
        long el = stk.peek();
        return (min > el) ? (int) min : (int) el;
    }

    public int getMin() {
        return (int)min;
    }
}
