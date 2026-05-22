package org.Projects.BinarySearch;

public class PeakElement {

    // TC = O(Log N)
    // SC = O(1)
    //even though the array is not sorted but still BS is used.
    public int findPeakElement(int[] arr) {
        int len = arr.length;

        if(len == 1) return 0; // if there is only 1 element in the array

        if(arr[len - 1] > arr[len - 2])  { // check if the last element is peak
            return len - 1;
        }

        if(arr[0] > arr[1]) { // check if the first element is peak
            return 0;
        }

        int st = 1, end = len - 2;

        while(st <= end) {
            int mid = st + (end - st) / 2;

            if((arr[mid] > arr[mid - 1]) && (arr[mid] > arr[mid + 1])) {
                return mid;
            } else if(arr[mid] < arr[mid + 1]) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
