package org.Projects.Graphs;

import java.util.ArrayList;

public class DFS {


    // TC = O(V + E) --> each vertex is visited once and each edge is traversed to check if we can visit a
    // neighbour or not

    // SC = O(V) --> for the visited array and the recursion stack space in worst case when the graph is a linear chain of vertices
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {

        // vis array to mark the visited nodes
        boolean[] vis = new boolean[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();

        dfsHelper(0, vis, adj, ans);
        return ans;
    }

    private void dfsHelper(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans){

        vis[node] = true;
        ans.add(node);

        for(int neighbour : adj.get(node)) {
            if(!vis[neighbour]) {
                dfsHelper(neighbour, vis, adj, ans);
            }
        }
    }
}
