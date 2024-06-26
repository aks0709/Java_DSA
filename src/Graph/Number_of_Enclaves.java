package Graph;

public class Number_of_Enclaves
{
    class Solution {
        void dfs(int row, int col,boolean vis[][],
                 int mat[][], int delrow[], int delcol[]) {
            vis[row][col] = true;
            int n = mat.length;
            int m = mat[0].length;

            // check for top, right, bottom, left
            for(int i = 0;i<4;i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                // check for valid coordinates and unvisited Os
                if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m
                        && vis[nrow][ncol] == false && mat[nrow][ncol] == 1) {
                    dfs(nrow, ncol, vis, mat, delrow, delcol);
                }
            }
        }
        public int numEnclaves(int[][] grid) {
            int n=grid.length;
            int m=grid[0].length;
            int delrow[]={-1,0,+1,0};
            int delcol[]={0,+1,0,-1};
            boolean vis[][]=new boolean[n][m];
            for(int j = 0 ; j<m;j++) {
                // check for unvisited Os in the boundary rws
                // first row
                if(vis[0][j] == false && grid[0][j] == 1) {
                    dfs(0, j, vis, grid, delrow, delcol);
                }

                // last row
                if(vis[n-1][j] == false&& grid[n-1][j] == 1) {
                    dfs(n-1,j,vis,grid, delrow, delcol);
                }
            }

            for(int i = 0;i<n;i++) {
                // check for unvisited Os in the boundary columns
                // first column
                if(vis[i][0] == false && grid[i][0] == 1) {
                    dfs(i, 0, vis, grid, delrow, delcol);
                }

                // last column
                if(vis[i][m-1] == false && grid[i][m-1] == 1) {
                    dfs(i, m-1, vis, grid, delrow, delcol);
                }
            }
            int count=0;

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(vis[i][j]==false&&grid[i][j]==1)
                    {
                        count++;
                    }
                }
            }

            return count;
        }

    }
}
