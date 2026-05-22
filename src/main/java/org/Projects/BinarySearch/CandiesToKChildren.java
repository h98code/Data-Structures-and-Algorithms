package org.Projects.BinarySearch;

public class CandiesToKChildren {


    // TC = O(N log(max))
    // SC = O(1)
    public int maximumCandies(int[] candies, long k) {
        int max = getMax(candies);
        int st = 1, end = max;

        int ans = 0;

        while(st <= end){
            int mid = st + (end - st) / 2;

            long countOfChildren = count(candies, mid);

            if(countOfChildren >= k) {
                ans = mid;
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    private long count(int candies[], int noOfCandies) {
        long ans = 0;

        for(int el : candies) {
            ans += (el / noOfCandies);
        }

        return ans;
    }

    private int getMax(int[] a) {
        int max = 1;

        for(int el : a) {
            max = Math.max(el, max);
        }

        return max;
    }
}
