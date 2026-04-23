package org.Projects.SlidingWindow.FixedSizeWindow;

public class DiffuseBomb {

    // TC = O(N)
    // SC = O(N)
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];

        if(k == 0)
            return ans;

        if(k > 0)
            helper(code, k, ans);
        else{
            reverse(code);
            helper(code, -k, ans);
            reverse(ans);
        }

        return ans;
    }

    private void helper(int[] code, int k, int[] ans){
        int sum = 0;

        for(int i=0; i<k; i++) sum += code[i];

        for(int i=0; i<code.length; i++){
            sum -= code[i];
            sum += code[(i + k) % (code.length)];
            ans[i] = sum;
        }
    }

    private void reverse(int[] a){
        int l = 0, r = a.length - 1;

        while(l < r){
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }
}
