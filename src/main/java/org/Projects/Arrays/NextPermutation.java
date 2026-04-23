package org.Projects.Arrays;

public class NextPermutation {


    // TC = O(N)
    // SC = O(1)
    public void nextPermutation(int[] nums) {

        boolean found = false;
        int len = nums.length;

        for(int i = len - 1; i > 0; i--){

            if (nums[i - 1] < nums[i]) {
                found = true;

                for(int j = len - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        reverse(nums, i, len - 1);
                        break;
                    }
                }

                if (found) {
                    break;
                }
            }
        }

        if (!found) {
            reverse(nums, 0, len - 1);
        }
    }

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void reverse(int[] a, int l, int r){
        while(l < r) {
            swap(a, l++, r--);
        }
    }
}
