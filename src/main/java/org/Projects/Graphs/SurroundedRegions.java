package org.Projects.Graphs;

public class SurroundedRegions {

    // TC = O(N x M)
    // SC = O(N x M)
    public void solve(char[][] board) {

        // start a dfs / bfs from the boundary cell and mark them "N" --> non-surrounded
        // convert all the other 'O' with 'X'
        // convert the 'N' to 'O';

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[0].length; c++){
                if(isBoundaryCell(r, c, board) && board[r][c] == 'O'){
                    dfs(r, c, board, dr, dc);
                }
            }
        }

        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[0].length; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }

                if(board[r][c] == 'N'){
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board, int[] dr, int[] dc){
        board[r][c] = 'N';

        for(int i=0; i<dr.length; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(isInBounds(nr, nc, board) && board[nr][nc] == 'O'){
                dfs(nr, nc, board, dr, dc);
            }
        }
    }

    private boolean isInBounds(int r, int c, char[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;

        if(r < 0 || r >= rows || c < 0 || c >= cols)
            return false;

        return true;
    }

    private boolean isBoundaryCell(int r, int c, char[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;

        if(r == 0 || r == rows - 1 || c == 0 || c == cols - 1)
            return true;

        return false;
    }
}
