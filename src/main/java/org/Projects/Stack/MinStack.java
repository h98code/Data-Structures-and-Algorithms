package org.Projects.Stack;

import java.util.Stack;

public class MinStack {

    // TC = O(1) for every operation
    // SC = O(2N)
    // space complexity can be further optimized to O(1)
    Stack<Integer> ms;
    Stack<Integer> s;

    public MinStack() {
        ms = new Stack<>();
        s = new Stack<>();
    }

    public void push(int value) {
        s.push(value);

        if(ms.isEmpty()) {
            ms.push(value);
        } else {
            if(value < ms.peek())
                ms.push(value);
            else
                ms.push(ms.peek());
        }
    }

    public void pop() {
        ms.pop();
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return ms.peek();
    }
}
