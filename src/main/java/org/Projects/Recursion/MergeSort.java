package org.Projects.Recursion;

public class MergeSort {
    // TC = O(N log N) --> log N for the number of levels in the recursion tree and N for merging the arrays at each level.
    // SC = O(N) --> for the temporary arrays used during merging.
    public int[] sortArray(int[] a) {
        if(a.length == 1)
            return a;

        int l = a.length;
        int[] u = new int[l/2];
        int[] v = new int[l-l/2];

        //populating the subarrays
        for(int i=0; i<a.length; i++){
            if(i < l/2){
                u[i] = a[i];
            }else{
                v[i - l/2] = a[i];
            }
        }

        u = sortArray(u);
        v = sortArray(v);
        return merge(a, u, v);
    }

    public int[] merge(int[] a, int[] u, int[] v){
        int up = 0, vp = 0;

        for(int ptr = 0; ptr < a.length; ptr++){
            if(up < u.length && vp < v.length){
                if(u[up] <= v[vp]){
                    a[ptr] = u[up++];
                }else{
                    a[ptr] = v[vp++];
                }
            }else if(up < u.length){
                a[ptr] = u[up++];
            }else{
                a[ptr] = v[vp++];
            }
        }

        return a;
    }
}
