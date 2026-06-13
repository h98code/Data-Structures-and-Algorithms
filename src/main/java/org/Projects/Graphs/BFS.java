package org.Projects.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    // TC = O(V + E)
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> bfsQ = new LinkedList<>();
        boolean[] vis = new boolean[adj.size()];

        bfsQ.add(0);
        vis[0] = true;

        while(!bfsQ.isEmpty()) {
            int sz = bfsQ.size();

            for(int i=0; i<sz; i++){
                int node = bfsQ.poll();
                ans.add(node);

                for(int neighbour : adj.get(node)) {
                    if(!vis[neighbour]) {
                        bfsQ.add(neighbour);
                        vis[neighbour] = true;
                    }
                }
            }
        }

        return ans;
    }
}
