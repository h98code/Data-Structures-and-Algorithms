package org.Projects.BinarySearch;

public class LowerBound {

    int lowerBound(int[] arr, int target) {
        // code here

        int st = 0, end = arr.length - 1;
        int index = arr.length;

        while(st <= end){
            int mid = st + (end - st) / 2;

            if(arr[mid] < target){
                st = mid + 1;
            } else {
                index = mid;
                end = mid - 1;
            }
        }

        return index;
    }
}
