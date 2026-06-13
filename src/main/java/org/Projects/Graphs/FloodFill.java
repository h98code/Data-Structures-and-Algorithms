package org.Projects.Graphs;

public class FloodFill {

    private int[] dr = {-1, 0, 0, 1};
    private int[] dc = {0, -1, 1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // dfs function for flood fill

        int originalColor = image[sr][sc];

        if(originalColor == newColor)
            return image;

        DFS(image, sr, sc, originalColor, newColor);

        //returns the image matrix
        return image;
    }

    private void DFS(int[][] a, int row, int col, int ogColor, int newColor){

        //marking the node as visited
        a[row][col] = newColor;

        for(int dir=0; dir < dr.length; dir++){

            int nr = row + dr[dir];
            int nc = col + dc[dir];

            if(isInbounds(a, nr, nc) && a[nr][nc] == ogColor){
                DFS(a, nr, nc, ogColor, newColor);
            }
        }
    }

    private boolean isInbounds(int[][] a, int r, int c){
        if(r < 0 || c < 0){
            return false;
        }

        if(r >= a.length || c >= a[0].length){
            return false;
        }

        return true;
    }
}
