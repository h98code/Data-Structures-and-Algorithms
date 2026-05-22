package org.Projects.BinarySearch;

public class KokoEatingBanana {

    // if eats max then all the bananas will finish in n hours
    // if eats 1 banana then it will take sum(arr) hours

    // k lies between 1 and max -> hours lies between [sum(arr), n];
    // k increase hours decrease
    // we are given h hours

    // for a k we check the time to finish if <= h we check for a smaller ans


    // TC = O(N log(max))
    // SC = O(1)
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for(int pile : piles){
            max = Math.max(max, pile);
        }

        return bs(piles, h, 1, max);
    }

    private int bs(int[] a, int h, int st, int end){
        while(st <= end){
            int mid = st + (end - st) / 2;

            long time = check(a, mid);

            if(time <= h){
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return st;
    }

    private long check(int[] a, int num){
        long ans = 0;

        for(int el : a){
            ans += (el % num == 0) ? (el / num) : (el / num) + 1;
        }

        return ans;
    }
}
