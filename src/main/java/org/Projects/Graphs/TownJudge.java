package org.Projects.Graphs;

public class TownJudge {

    // TC = O(N)
    // SC = O(N) can also be done using a single array
    public int findJudge(int n, int[][] trust) {

        if(trust.length < n - 1)
            return -1;

        int[] in = new int[n + 1];
        int[] out = new int[n + 1];

        for(int[] edge : trust) {
            out[edge[0]]++;
            in[edge[1]]++;
        }

        for(int i=1; i<=n; i++) {
            if(out[i] == 0 && in[i] == n - 1)
                return i;
        }

        return -1;
    }
}
