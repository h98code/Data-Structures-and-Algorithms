package org.Projects.Arrays;

public class TrappingRainwater {

    public int trap(int[] height) {

        int lmax = 0, rmax = 0;
        int l = 0, r = height.length - 1;
        int ans = 0;

        while(l < r){

            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            // if the max found so far in left is smaller than in the right, then it will decide the boundary
            // of the water to be stored
            ans += (lmax <= rmax) ? (lmax - height[l++]) : (rmax - height[r--]);
        }

        return ans;
    }
}
