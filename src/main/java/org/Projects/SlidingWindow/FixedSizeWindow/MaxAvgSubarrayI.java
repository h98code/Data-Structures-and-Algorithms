package org.Projects.SlidingWindow.FixedSizeWindow;

public class MaxAvgSubarrayI {

    // TC = O(N)
    // SC = O(1)
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double avg = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(i >= k - 1){
                if(i >= k)
                    sum -= nums[i - k];

                avg = Math.max(avg, sum / k);
            }
        }

        return avg;
    }
}
