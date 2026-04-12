package org.Projects.Stack;

import java.util.Stack;

public class NextGreaterElement2 {

    //think of circular array as 2 arrays back to back

    // TC = O(N)
    // SC = O(N)
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        Stack<Integer> stk = new Stack<>();

        for(int i=n-1; i>=0; i--)
            stk.push(nums[i]);

        int nge[] = new int[n];
        nge(nums, n, nge, stk);

        return nge;
    }

    private void nge(int[] nums, int n, int[] nge, Stack<Integer> stk){

        for(int i=n-1; i>=0; i--){
            while(!stk.isEmpty() && (stk.peek() <= nums[i]))
                stk.pop();

            nge[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[i]);
        }
    }
}
