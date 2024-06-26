package Graph;

import java.util.LinkedList;
import java.util.Queue;
//Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
//
//The distance between two adjacent cells is 1.
public class Matrix_01
{
    class Pair{
        int row;
        int col;
        int level;
        public Pair(int row,int col,int level)
        {
            this.row=row;
            this.col=col;
            this.level=level;
        }
    }
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int n=mat.length;
            int m=mat[0].length;
            int dis[][]=new int[n][m];
            boolean vis[][]=new boolean[n][m];
            Queue<Pair> q=new LinkedList<Pair>();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(mat[i][j]==0)
                    {
                        q.add(new Pair(i,j,0));
                        vis[i][j]=true;
                    }
                }
            }

            int delRow[]={-1,0,+1,0};
            int delCol[]={0,+1,0,-1};

            while(!q.isEmpty()){
                int r=q.peek().row;
                int c=q.peek().col;
                int steps=q.peek().level;
                q.remove();
                dis[r][c]=steps;
                for(int i=0;i<4;i++)
                {
                    int nRow=r+delRow[i];
                    int nCol=c+delCol[i];

                    if(nRow>=0&&nRow<n&&nCol>=0&&nCol<m&&vis[nRow][nCol]==false)
                    {
                        q.add(new Pair(nRow,nCol,steps+1));
                        vis[nRow][nCol]=true;
                    }
                }
            }
            return dis;
        }
    }
}
