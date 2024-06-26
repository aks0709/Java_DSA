package Graph;
import java.util.*;
public class PathWithMinEffort
{
    class Pair{
        int distance;
        int row;
        int col;
        public Pair(int distance,int row,int col)
        {
            this.distance=distance;
            this.row=row;
            this.col=col;
        }
    }
    class Solution {

        int MinimumEffort(int heights[][]) {
            int n=heights.length;
            int m=heights[0].length;
            int rd=n-1;
            int cd=m-1;
            int diff[][]=new int[n][m];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    diff[i][j]=(int)(1e9);
                }
            }

            diff[0][0]=0;
            PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.distance-y.distance);
            pq.add(new Pair(0,0,0));

            int delRow[]={-1,0,+1,0};
            int delCol[]={0,+1,0,-1};
            while(pq.size()!=0){
                Pair it=pq.peek();
                int r=it.row;
                int c=it.col;
                int dis=it.distance;
                pq.remove();

                if(r==rd&&c==cd) return dis;

                for(int i=0;i<4;i++)
                {
                    int nrow=r+delRow[i];
                    int ncol=c+delCol[i];

                    if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m)
                    {
                        int newEffort=Math.max(
                                Math.abs(heights[r][c] - heights[nrow][ncol]), dis);

                        if(newEffort < diff[nrow][ncol]) {
                            diff[nrow][ncol] = newEffort;
                            pq.add(new Pair(newEffort, nrow, ncol));
                        }

                    }
                }
            }
            return 0;
        }
    }
}
