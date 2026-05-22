package org.Projects.BinarySearch;

public class MBouquets {


    // TC = O(N log(max))
    // SC = O(1)
    public int minDays(int[] bloomDay, int m, int k) {

        if(k * m > bloomDay.length) {
            return -1;
        }

        int st = 1, end = getMax(bloomDay);
        int ans = -1;

        while(st <= end){

            int mid = st + (end - st) / 2;

            if(bouquetsFormedOnDay(mid, bloomDay, k) < m) {
                st = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;
    }

    private int bouquetsFormedOnDay(int day, int[] a, int k) {
        int count = 0;
        int ans = 0;

        for(int el : a) {
            if(el <= day) {
                count++;
            } else {
                ans += (count / k);
                count = 0;
            }
        }

        ans += (count / k);

        return ans;
    }

    private int getMax(int[] a){
        int max = Integer.MIN_VALUE;

        for(int el : a){
            max = Math.max(el, max);
        }

        return max;
    }
}
