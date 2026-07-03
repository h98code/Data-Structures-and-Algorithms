package org.Projects.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<Integer>[] adj = convertToAdjList(edges, V);

        boolean vis[] = new boolean[V];
        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<V; i++){
            if(!vis[i]) {
                dfs(i, vis, adj, stk);
            }
        }

        while(!stk.isEmpty()) {
            ans.add(stk.pop());
        }

        return ans;
    }

    private void dfs(int node, boolean[] vis, List<Integer>[] adj, Stack<Integer> stk) {
        vis[node] = true;

        for(int neighbour : adj[node]) {
            if(!vis[neighbour]) {
                dfs(neighbour, vis, adj, stk);
            }
        }

        stk.push(node);
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
