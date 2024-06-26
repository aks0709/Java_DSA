package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenTomatos
{
    public static void main(String[] args) {

    }
    class Pair
    {
        int row;
        int col;
        int time;
        public Pair(int row,int col,int time)
        {
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    class Solution
    {
        //Function to find minimum time required to rot all oranges.
        public int orangesRotting(int[][] grid)
        {
            // Code here
            int n=grid.length;
            int m=grid[0].length;
            Queue<Pair> q=new LinkedList<Pair>();
            int vis[][]=new int[n][m];
            int countFresh=0;  //to track initial number of fresh oranges
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(grid[i][j]==2){
                        q.add(new Pair(i,j,0));
                        vis[i][j]=2;
                    }
                    else
                    {
                        vis[i][j]=0;
                    }

                    if(grid[i][j]==1){
                        countFresh++;
                    }
                }
            }

            int tm=0; //Max time
            int delRow[]={-1,0,1,0};
            int delCol[]={0,1,0,-1};
            int count=0;//it track no fresh oranges tuen into rotten oranges
            while(!q.isEmpty())
            {
                int r=q.peek().row;
                int c=q.peek().col;
                int t=q.peek().time;
                q.remove();
                tm=Math.max(tm,t);
                for(int i=0;i<4;i++)
                {
                    int nrow=r+delRow[i];
                    int ncol=c+delCol[i];

                    //constraints

                    if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0&&grid[nrow][ncol]==1)
                    {
                        q.add(new Pair(nrow,ncol,t+1));
                        vis[nrow][ncol]=2;
                        count++;
                    }
                }
            }
            if(countFresh!=count)
                return -1;

            return tm;

        }
    }
}

