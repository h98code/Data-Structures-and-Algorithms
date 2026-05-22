package org.Projects.BinarySearch;

public class UpperBound {

    int upperBound(int[] arr, int target) {
        // code here

        int ans = arr.length;
        int st = 0, end = arr.length - 1;

        while(st <= end){
            int mid = st + (end - st) / 2;

            if(arr[mid] <= target){
                st = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;
    }
}
