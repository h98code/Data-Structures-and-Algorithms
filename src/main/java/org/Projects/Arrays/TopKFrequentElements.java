package org.Projects.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    class Pair{
        int val;
        int fr;

        Pair(int fr, int val) {
            this.val = val;
            this.fr = fr;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // count the freq using map
        // use a heap of pairs


        Map<Integer, Integer> mp = new HashMap<>();
        for(int el : nums) {
            mp.put(el, mp.getOrDefault(el, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> (p1.fr - p2.fr));

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            pq.add(new Pair(entry.getValue(), entry.getKey()));

            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] ans = new int[pq.size()];
        int ptr = 0;
        while(!pq.isEmpty()) {
            ans[ptr++] = pq.poll().val;
        }

        return ans;
    }
}
