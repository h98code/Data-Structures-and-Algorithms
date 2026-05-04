package org.Projects.SlidingWindow.VariableSizeWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {

    // TC = O(N) sliding window and 1 time travesal of the array
    // SC = O(N) hashmap to store the number of fruits of each type in the current window
    public int totalFruit(int[] fruits) {

        int ans = 0;
        int left = 0;

        //map to store the different types of fruits we have encountered.
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<fruits.length; i++){
            int curr = fruits[i];

            //adding the fruit to the map
            mp.put(curr, mp.getOrDefault(curr, 0) + 1);

            //we have more than 2 types of fruits
            while(mp.size() > 2){
                int leftEl = fruits[left];

                mp.put(leftEl, mp.get(leftEl) - 1);
                if(mp.get(leftEl) == 0)
                    mp.remove(leftEl);

                left++;
            }

            ans = Math.max(ans, i - left);
        }

        return ans + 1;
    }
}
