package org.Projects.Stack;

import java.util.Stack;

public class LargestAreaOfHistogram {


    // TC = O(N)
    // SC = O(N)
    // nse and pse of every element is calculated on the go without storing
    public int largestRectangleAreaSinglePass(int[] heights) {
        int ans = 0;
        int n = heights.length;

        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]){
                int topIndex = stk.pop();
                int topElement = heights[topIndex];
                int nse = i;
                int pse = stk.isEmpty() ? -1 : stk.peek();
                ans = Math.max(ans, (nse - pse - 1) * topElement);
            }

            stk.push(i);
        }

        while(!stk.isEmpty()){
            int topIndex = stk.pop();
            int topEl = heights[topIndex];
            int nse = heights.length;
            int pse = stk.isEmpty() ? -1 : stk.peek();
            ans = Math.max(ans, (nse - pse - 1) * topEl);

        }

        return ans;
    }


    // TC = O(N)
    // SC = O(N)

    // can be further optimized by calculating the nse and pse in a single go.
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int ans = 0;

        int nse[] = new int[n];
        int pse[] = new int[n];

        nextSmallerElement(heights, nse);
        previousSmallerElement(heights, pse);

        print(nse);
        print(pse);

        for(int i=0; i<n; i++){
            ans = Math.max(ans, (nse[i] - pse[i] - 1) * heights[i]);
        }

        return ans;
    }

    public void nextSmallerElement(int[] a, int[] nse) {

        // stores the indices of the next smallest element
        Stack<Integer> stk = new Stack<>();
        int ptr = a.length - 1;

        for(int i=ptr; i>=0; i--) {
            while(!stk.isEmpty() && a[stk.peek()] >= a[i]){
                stk.pop();
            }

            if(stk.isEmpty()) {
                nse[ptr--] = a.length;
            } else {
                nse[ptr--] = stk.peek();
            }

            stk.push(i);
        }
    }

    public void previousSmallerElement(int[] a, int[] nse) {

        // stores the indices of the next smallest element
        Stack<Integer> stk = new Stack<>();
        int ptr = 0;

        for(int i=ptr; i<a.length; i++) {
            while(!stk.isEmpty() && a[stk.peek()] >= a[i]){
                stk.pop();
            }

            if(stk.isEmpty()) {
                nse[ptr++] = -1;
            } else {
                nse[ptr++] = stk.peek();
            }

            stk.push(i);
        }
    }

    private void print(int[] a) {
        for(int el : a) {
            System.out.print(el + " ");
        }

        System.out.println();
    }
}
