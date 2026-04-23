package org.Projects.SlidingWindow.FixedSizeWindow;

public class KBeautyOfNumber {

    // TC = O(NK)
    // SC = O(N^2)
    public int divisorSubstrings(int num, int k) {
        int ans = 0;
        String number = Integer.toString(num);

        for(int i=0; i<=number.length() - k; i++){
            StringBuilder sb = new StringBuilder();

            for(int j=1; j<=k; j++){
                sb.append(number.charAt(i + j - 1));
            }

            int temp = Integer.parseInt(sb.toString());

            if(temp == 0)
                continue;

            ans = num % temp == 0 ? ans + 1 : ans;
        }

        return ans;
    }
}
