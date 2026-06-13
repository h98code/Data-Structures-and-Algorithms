package org.Projects.Arrays;

public class ProductOfArrayExceptSelf {

    // TC = O(N)
    // SC = O(1)
    // can also be done by using prefix and suffix

    public int[] productExceptSelf(int[] nums) {
        int countZero = 0;
        int pro = 1;

        for(int el : nums){
            if(el == 0) {
                countZero++;
            } else {
                pro *= el;
            }
        }

        int[] ans = new int[nums.length];

        if(countZero > 1) {
            return ans;
        }

        for(int i=0; i<nums.length; i++){
            if(countZero == 1) {
                ans[i] = nums[i] == 0 ? pro : 0;
            } else {
                ans[i] = pro / nums[i];
            }
        }

        return ans;
    }
}
