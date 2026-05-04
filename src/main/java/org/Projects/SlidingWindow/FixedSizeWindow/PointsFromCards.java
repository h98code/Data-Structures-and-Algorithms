package org.Projects.SlidingWindow.FixedSizeWindow;

public class PointsFromCards {

    // TC = O(K)
    // SC = O(1)
    public int maxScore(int[] cardPoints, int k) {

        // initializing variables
        int sum = 0;
        int len = cardPoints.length;
        int baseIndex = len - k;

        for(int i = baseIndex; i < len; i++)
            sum += cardPoints[i];

        int maxSum = sum;

        for(int i=0; i<k; i++){
            //add the next element in the window
            sum += cardPoints[(baseIndex + k + i) % len];

            //remove the first element from the window
            sum -= cardPoints[baseIndex + i];

            //check the maxSum with the current sum of the window
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}
