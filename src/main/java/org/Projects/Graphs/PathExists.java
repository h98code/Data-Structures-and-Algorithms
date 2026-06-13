package org.Projects.Graphs;

import java.util.ArrayList;

public class PathExists {

    // TC = O(V + E)
    // SC = O(V) for the visited array and the recursion stack space in worst case when the graph is a linear chain of vertices
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // create adj list and then use dfs / bfs on the source and check if the destination can be visited

        ArrayList<Integer>[] adj = new ArrayList[n];

        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        dfs(source, adj, vis);

        return vis[destination];
    }

    private void dfs(int node, ArrayList<Integer>[] adj, boolean[] vis) {
        vis[node] = true;

        for(int neighbour : adj[node]) {
            if(!vis[neighbour]) {
                dfs(neighbour, adj, vis);
            }
        }
    }
}
