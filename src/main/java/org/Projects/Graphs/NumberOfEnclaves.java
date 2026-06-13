package org.Projects.Graphs;

public class NumberOfEnclaves {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int numEnclaves(int[][] grid) {

        int ans = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(BoundaryCell(i, j, grid) && 1 == grid[i][j]) {
                    dfs(i, j, grid);
                }
            }
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1) ans++;
            }
        }

        return ans;
    }

    private void dfs(int r, int c, int[][] grid){
        grid[r][c] = 2;

        for(int i=0; i<dx.length; i++){
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(isInBounds(nr, nc, grid) && grid[nr][nc] == 1){
                dfs(nr, nc, grid);
            }
        }
    }

    private boolean BoundaryCell(int i, int j, int[][] grid){
        return (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1);
    }

    private boolean isInBounds(int r, int c, int[][] grid){
        return !(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length);
    }
}
