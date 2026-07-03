package org.Projects.Graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleInDirectedGraph {

    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<Integer>[] adj = convertToAdjList(edges, V);

        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for(int i=0; i<V; i++){
            if(dfs(i, adj, vis, pathVis)) return true;
        }

        return false;
    }

    // check if the graph is cyclic or not
    private boolean dfs(int node, List<Integer>[] adj, boolean[] vis, boolean[] pathVis) {

        vis[node] = true;
        pathVis[node] = true;

        for(int neighbour : adj[node]) {
            if(pathVis[neighbour]) return true;

            if(!vis[neighbour]) {
                if(dfs(neighbour, adj, vis, pathVis)) return true;
            }
        }

        pathVis[node] = false;
        return false;
    }

    private List<Integer>[] convertToAdjList(int[][] edges, int V) {
        List<Integer>[] adj = new List[V];

        for(int i=0; i<V; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }

        return adj;
    }
}
