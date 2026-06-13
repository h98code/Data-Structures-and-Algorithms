package org.Projects.Graphs;

import java.util.ArrayList;

public class CompleteConnectedComponent {

    // TC = O(V + E)
    // SC = O(V)
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[n];

        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int ans = 0;
        boolean[] vis = new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]) {
                int[] comp = new int[2]; // contains edges, vertices of a connected component
                dfs(i, vis, adj, comp);

                int edgesCount = comp[0];
                int nodes = comp[1];

                System.out.println("Starting node : " + i);
                System.out.println("e : " + edgesCount + " v : " + nodes);

                if( (nodes * (nodes - 1) == edgesCount)) ans++;
            }
        }

        return ans;
    }

    private void dfs(int node, boolean[] vis, ArrayList<Integer>[] adj, int[] comp) {
        vis[node] = true;

        comp[0] += adj[node].size(); // adding the number of edges of the current node
        comp[1] += 1;

        for(int neighbour : adj[node]){
            if(!vis[neighbour]) {
                dfs(neighbour, vis, adj, comp);
            }
        }
    }
}
