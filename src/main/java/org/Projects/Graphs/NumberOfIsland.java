package org.Projects.Graphs;

import org.Projects.Util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {

    public int numIslands(char[][] grid) {
        // find the number of connected components in a matrix
        // apply dfs on every cell of the matrix
        // can change the value of the cell to mark the node as visited
        // a node is represented by <row,col>

        // dfs on the grid cell
        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        int ans = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1') {
                    dfs(i, j, grid, dr, dc);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void bfs(int r, int c, char[][] grid, int[] dr, int[] dc){
        Queue<Pair> bfsQ = new LinkedList<>();
        bfsQ.add(new Pair(r,c));
        grid[r][c] = '2';

        while(!bfsQ.isEmpty()){
            int size = bfsQ.size();

            for(int i=0; i<size; i++){
                Pair p = bfsQ.poll();
                int row = p.row;
                int col = p.col;

                for(int dir=0; dir<dr.length; dir++){
                    int newRow = row + dr[dir];
                    int newCol = col + dc[dir];

                    if(isInBounds(newRow, newCol, grid) && grid[newRow][newCol] == '1'){
                        bfsQ.add(new Pair(newRow, newCol));
                        grid[newRow][newCol] = '2';
                    }
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] grid, int[] dr, int[] dc) {

        grid[r][c] = '2'; // marking the current node as visited

        // traversing the adjacent nodes of the current node
        for(int i=0; i<dr.length; i++) {
            int newRow = r + dr[i];
            int newCol = c + dc[i];

            if(isInBounds(newRow, newCol, grid) && grid[newRow][newCol] == '1') {
                dfs(newRow, newCol, grid, dr, dc);
            }
        }
    }

    private boolean isInBounds(int r, int c, char[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;

        if(r >= rows || c >= cols || r < 0 || c < 0) return false;

        return true;
    }
}
