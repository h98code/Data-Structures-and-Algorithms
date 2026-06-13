package org.Projects.Graphs;

public class CenterOfStarGraph {

    // TC = O(N)
    // SC = O(1)
    public int findCenter(int[][] edges) {
        // the center node will be present in every edge
        // consider 1st 2 edges, the center node will be present twice and the other 2 nodes once

        int node1 = edges[0][0];
        int node2 = edges[0][1];
        int node3 = edges[1][0];

        if(node3 == node1 || node3 == node2) return node3;

        return edges[1][1];
    }
}
