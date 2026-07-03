package org.Projects.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSortBFS {

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here

        ArrayList<Integer> ans = new ArrayList<>();

        List<Integer>[] adj = convertToAdjList(edges, V);
        int[] indegree = new int[V];

        for(int[] edge : edges) {
            indegree[edge[1]]++;
        }

        Queue<Integer> bfsQ = new LinkedList<>();

        for(int i=0; i<V; i++) {
            if(indegree[i] == 0) {
                bfsQ.add(i);
            }
        }

        while(!bfsQ.isEmpty()) {

            int size = bfsQ.size();
            for(int i=0; i<size; i++) {
                int node = bfsQ.poll();
                ans.add(node);

                for(int neighbour : adj[node]) {
                    indegree[neighbour]--;

                    if(indegree[neighbour] == 0) {
                        bfsQ.add(neighbour);
                    }
                }
            }
        }

        if(ans.size() == V)
            return ans;

        return new ArrayList<>();

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
