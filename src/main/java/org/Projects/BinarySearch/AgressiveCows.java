package org.Projects.BinarySearch;

import java.util.Arrays;

public class AgressiveCows {

    // TC = O(N log(max))
    // SC = O(1)
    public int aggressiveCows(int[] stalls, int k) {
        // code here

        //sort the stalls array
        Arrays.sort(stalls);

        int st = 1, end = getMax(stalls);
        int ans = end + 1;

        while(st <= end) {
            int mid = st + (end - st) / 2;

            if(possible(stalls, k - 1, mid)) {
                ans = mid;
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    private int getMax(int[] a){
        int max = -1;

        for(int el : a) { max = Math.max(max, el); }

        return max;
    }

    private boolean possible(int[] a, int k, int dist) {
        int prev = a[0];

        for(int i=1; i<a.length; i++){
            if(prev + dist <= a[i]) {
                k--;
                prev = a[i];
            }
        }

        return k <= 0;
    }
}
