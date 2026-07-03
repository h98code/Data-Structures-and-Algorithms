package org.Projects.Graphs;

public class IsGraphBiPartite {

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;

        int[] color = new int[V]; // tracking the color of the node and marking it visited
        int color_to_be_filled = 1;

        //checking for all the connected components
        for(int i=0; i<V; i++) {
            if(color[i] == 0) { // node not visited
                if(!dfs(i, graph, color, color_to_be_filled)) return false;
            }
        }

        return true;
    }

    // function to check whther the graph is bi partite or not
    private boolean dfs(int node, int[][] graph, int[] color, int color_to_be_filled) {

        // marking the node as visited and it's color
        color[node] = color_to_be_filled;

        int neighbour_color = (color[node] == 1) ? 2 : 1;

        for(int neighbour : graph[node]) {
            if(color[neighbour] == color[node]) {
                return false;
            }

            if(color[neighbour] == 0) {
                if(!dfs(neighbour, graph, color, neighbour_color)) return false;
            }
        }

        return true;
    }
}
