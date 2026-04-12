package org.Projects.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    //can be done using brute force approach // find the element and then find the NGE
    //            O(N^2)


    // TC = O(N)
    // SC = O(N)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int nge[] = new int[nums2.length];

        nge(nums2, nge);

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums2.length; i++)
            mp.put(nums2[i], i);

        int ans[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nge[mp.get(nums1[i])];
        }

        return ans;
    }

    private void nge(int[] nums2, int[] nge) {

        Stack<Integer> stk = new Stack<>();
        int ptr = nums2.length - 1;

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <=   nums2[i])
                stk.pop();

            nge[ptr--] = stk.isEmpty() ? -1 : stk.peek();

            stk.push(nums2[i]);
        }
    }
}
