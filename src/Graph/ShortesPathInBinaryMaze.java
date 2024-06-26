package Graph;
import java.util.*;
public class ShortesPathInBinaryMaze
{
    class Pair{
        int row;
        int col;
        int distance;
        public Pair(int distance,int row,int col)
        {
            this.distance=distance;
            this.row=row;
            this.col=col;
        }
    }
    class Solution {

        int shortestPath(int[][] grid, int[] source, int[] destination) {

            // Your code here
            int n=grid.length;
            int m=grid[0].length;
            int vis[][]=new int[n][m];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    vis[i][j]=(int)(1e9);
                }
            }
            int rs=source[0];
            int cs=source[1];
            int rd=destination[0];
            int cd=destination[1];

            if(rs== rd && cs== cd) return 0;  //edge case
            vis[rs][cs]=0;
            Queue<Pair> q=new LinkedList<>();
            q.add(new Pair(0,rs,cs));
            int delRow[]={-1,0,+1,0};
            int delCol[]={0,+1,0,-1};
            while(!q.isEmpty()){
                int r=q.peek().row;
                int c=q.peek().col;
                int dis=q.peek().distance;
                q.remove();

                for(int i=0;i<4;i++)
                {
                    int nrow=r+delRow[i];
                    int ncol=c+delCol[i];

                    if(nrow<n&&nrow>=0&&ncol<m&&ncol>=0&&grid[nrow][ncol]==1)
                    {
                        if(dis+1<vis[nrow][ncol])
                        {
                            vis[nrow][ncol]=dis+1;
                            if(nrow==rd&&ncol==cd)
                                return dis+1;

                            q.add(new Pair(vis[nrow][ncol],nrow,ncol));
                        }
                    }
                }
            }

            return -1;

        }
    }

}
