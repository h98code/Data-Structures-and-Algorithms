package org.Projects.Graphs;

public class NumberOfProvinces {

    // TC = O(V^2) as adj matrix was given and not adj list
    // SC = O(V) boolean vis array
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;

        boolean vis[] = new boolean[v];
        int ans = 0;

        for(int i=0; i<v; i++){
            if(!vis[i]){
                dfs(i, isConnected, vis);
                ans++;
            }
        }

        return ans;
    }

    private void dfs(int node, int[][] mat, boolean[] vis){
        vis[node] = true;

        for(int i=0; i<mat[node].length; i++){
            if(mat[node][i] == 1) { // if the edge exists
                if(!vis[i]) {
                    dfs(i, mat, vis);
                }
            }
        }
    }
}
