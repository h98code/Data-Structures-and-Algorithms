package org.Projects.Stack;

import java.util.Stack;

//instead of calculating nse and pse in 2 different arrays, we can do it in a single pass using the popping trick.
// Whenever we pop an element from the stack, we can calculate its contribution to the answer using the indices of the previous and next smaller elements.


// popping of an element will happen when we find the next smaller element while array traversal
// pse is the element just below the popping element.

public class SumOfSubarrayMinimums {

    // TC = O(N) --> single pass solution.
    // SC = O(N)

    public int sumSubarrayMins(int[] arr) {
        // compute the prev smaller array
        // compute the next smaller array
        // do the computations for every element in the array.

        int n = arr.length;
        int mod = 1_000_000_007;
        int ans = 0;

        Stack<Integer> stk = new Stack<>(); // to store the indices of the array elements

        for(int i=0; i<=arr.length; i++){

            int curr = (i == arr.length) ? 0 : arr[i];

            while(!stk.isEmpty() && (arr[stk.peek()] >= curr))
            {
                //popping trick to calc boundaries
                int midIndex = stk.pop();
                int leftBoundaryIndex = -1;
                int rightBoundaryIndex = i;

                if(!stk.isEmpty())
                    leftBoundaryIndex = stk.peek();

                long leftContri = (midIndex - leftBoundaryIndex);
                long rightContri = (rightBoundaryIndex - midIndex);

                long temp = ((leftContri % mod) * (rightContri % mod)) % mod;
                temp = (temp * (arr[midIndex] % mod)) % mod;
                ans = (ans % mod + (int)temp % mod) % mod;
            }

            stk.push(i);
        }

        return ans;
    }
}
