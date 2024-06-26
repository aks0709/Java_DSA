package Graph;

import java.util.LinkedList;
import java.util.Queue;

//Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid)
// consisting of '0's (Water) and '1's(Land). Find the number of islands.
//Note: An island is either surrounded by water or boundary of grid and is formed by connecting
// adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
public class noOfIslands
{
    class Pair{
        int first;
        int second;
        public Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    class Solution {
        // Function to find the number of islands.
        public void BFS(int ro,int co,boolean[][] vis,char[][]grid)
        {
            vis[ro][co]=true;
            Queue<Pair> q=new LinkedList<Pair>();

            int n=grid.length;
            int m=grid[0].length;
            q.add(new Pair(ro,co));

            while(!q.isEmpty())
            {
                int row=q.peek().first;
                int col=q.peek().second;
                q.remove();

                for(int delRow=-1;delRow<=1;delRow++)
                {
                    for(int delcol=-1;delcol<=1;delcol++)
                    {
                        int nRow=row+delRow;
                        int nCol=col+delcol;
                        if((nRow>=0&&nRow<n&&nCol>=0&&nCol<m)&&(grid[nRow][nCol]=='1'&&!vis[nRow][nCol]))
                        {
                            vis[nRow][nCol]=true;
                            q.add(new Pair(nRow,nCol));
                        }
                    }

                }
            }
        }

        public int numIslands(char[][] grid) {
            // Code here
            int n=grid.length;
            int m=grid[0].length;
            boolean [][]vis=new boolean[n][m];
            int count=0;
            for(int row=0;row<n;row++)
            {
                for(int col=0;col<m;col++)
                {
                    if(!vis[row][col]&&grid[row][col]=='1')
                    {
                        count++;
                        BFS(row,col,vis,grid);
                    }
                }
            }
            return count;
        }
    }
    public static void main(String[] args) {

    }
}
