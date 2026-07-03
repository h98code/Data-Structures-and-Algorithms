package org.Projects.Arrays;

import java.util.HashMap;
import java.util.Map;

public class MatrixWithNums1ToN {

    // TC = O(N^2)
    // SC = O(N)

    // can be optimized by using xor OR sum methods
    public boolean checkValid(int[][] matrix) {

        int n = matrix.length;

        // map to store the element 1 to n with freq 0
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=1; i<=n; i++) {
            mp.put(i, 0);
        }

        // check for rows
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int el = matrix[i][j];

                if(el > n || el < 1 || mp.get(el) >= (i + 1)) return false;

                mp.put(el, mp.get(el) + 1);
            }
        }

        // check for cols
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int el = matrix[j][i];

                if(el > n || el < 1 || mp.get(el) >= (i + 1 + n)) return false;

                mp.put(el, mp.get(el) + 1);
            }
        }

        return true;
    }
}
