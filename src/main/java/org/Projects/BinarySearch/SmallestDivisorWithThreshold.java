package org.Projects.BinarySearch;

public class SmallestDivisorWithThreshold {

    // TC = O(N log M) where M is the max element of the array,
    // SC = O(1)
    public int smallestDivisor(int[] nums, int threshold) {
        int st = 1, end = 0;

        //fetching the max value of the array
        for(int i = 0; i<nums.length; i++){
            end = Math.max(end, nums[i]);
        }

        while(st <= end){
            int mid = st + (end - st)/2;

            int tempAns = divide(nums, mid);

            if(tempAns <= threshold) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return st;
    }

    private int divide(int[] a, int x){
        int sum = 0;

        for(int el : a){

            sum += (el / x);

            if(el % x != 0)
                sum += 1;
        }

        return sum;
    }
}
