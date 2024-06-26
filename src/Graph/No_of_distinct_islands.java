package Graph;

import java.util.ArrayList;
import java.util.HashSet;
public class No_of_distinct_islands
{

    class Solution {

        int countDistinctIslands(int[][] grid) {
            // Your Code here
            int n=grid.length;
            int m=grid[0].length;
            boolean vis[][]=new boolean[n][m];
            HashSet<ArrayList<String>> st=new HashSet<>();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(!vis[i][j]&&grid[i][j]==1)
                    {
                        ArrayList<String> list=new ArrayList<>();
                        DFS(i,j,list,vis,grid,i,j);
                        st.add(list);
                    }
                }
            }
            return st.size();
        }
        private String toString(int r,int c)//two parameter toString
        {
            return Integer.toString(r)+" "+Integer.toString(c);
        }
        public  void DFS(int row, int col, ArrayList<String> list, boolean vis[][], int grid[][], int row0, int col0)
        {
            vis[row][col]=true;
            list.add(toString(row-row0,col-col0));
            int n=grid.length;
            int m=grid[0].length;
            int delrow[]={-1,0,+1,0};
            int delcol[]={0,-1,0,+1};
            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&!vis[nrow][ncol]&&grid[nrow][ncol]==1)
                {
                    DFS(nrow,ncol,list,vis,grid,row0,col0);
                }
            }
        }

    }

}
