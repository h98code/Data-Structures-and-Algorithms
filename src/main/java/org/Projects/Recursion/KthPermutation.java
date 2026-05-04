package org.Projects.Recursion;

public class KthPermutation {

    // TC = O(N ^ 2)
    // SC = O(N) array + recursion depth
    public String getPermutation(int n, int k) {
        int nFac = factorial(n);

        StringBuilder sb = new StringBuilder();

        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = i + 1;
        }

        helper(sb, a, a.length - 1, nFac, n, k);

        return sb.toString();
    }

    private void helper(StringBuilder sb, int[] a, int end, int nfac, int pf, int k){
        if(k == 0){
            for(int i = end; i>=0; i--)
                sb.append(a[i]);

            return;
        }

        int fac = nfac / pf;

        int index = (k % fac == 0) ? (k / fac) - 1 : (k / fac);
        sb.append(a[index]);
        moveArray(a, index, end);

        helper(sb, a, end - 1, fac, pf - 1, k % fac);
    }

    private void moveArray(int[] a, int index, int end){
        if(index == end) return;

        for(int i=index; i<end; i++){
            a[i] = a[i + 1];
        }
    }

    public int factorial(int n){
        if(n <= 1)
            return 1;

        return n * factorial(n - 1);
    }
}
