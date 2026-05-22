package org.Projects.BinarySearch;

public class MinElementInRotatedSortedArray {


    // TC = O(log N)
    // SC = O(1)
    public int findMin(int[] nums) {
        int st = 0, end = nums.length - 1;

        while(st <= end){
            int mid = st + (end - st) / 2;

            if(nums[mid] > nums[end]){
                st = mid + 1;
            } else {
                if(isSmallest(nums, mid)) return nums[mid];

                end = mid - 1;
            }
        }

        return -1;
    }

    private boolean isSmallest(int[] a, int mid){

        // size of the array is 1
        if(a.length == 1)
            return true;

        // index is present in the mid
        if(mid > 0 && mid < a.length - 1){
            return a[mid] < a[mid + 1] && a[mid] < a[mid - 1];
        }

        // if mid is the first element of arr
        if(mid == 0){
            return a[mid] < a[mid + 1];
        }

        return a[mid] < a[mid - 1]; // if mid is the last element
    }
}
