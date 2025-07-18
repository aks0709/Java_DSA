package Graph.Revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RottenTomatos {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        ArrayList<Pair> arr=new ArrayList<Pair>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2)
                    arr.add(new Pair(i,j));
                if(grid[i][j]==1)
                    fresh++;
            }
        }

        if(arr.size()!=0 &&fresh ==0) //when all
            return 0;
        else if(arr.size()==0 && fresh ==0) //case of no oranges
            return 0;
        else if(arr.size()==0 || fresh==0)  //it either have no fresh orange or rotten
            return -1;
        Queue<ArrayList<Pair>> q=new LinkedList<>();
        q.add(arr);
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1};
        int time=0;
        while(!q.isEmpty()){
            ArrayList<Pair> retrived=q.poll();
            ArrayList<Pair> rotten=new ArrayList<Pair>();
            for(Pair p: retrived){
                int row=p.first;
                int col=p.second;
                for(int i=0;i<4;i++){
                    int nrow = row + delRow[i];
                    int ncol = col + delCol[i];
                    if(nrow<n && nrow>=0&&ncol<m && ncol>=0 && grid[nrow][ncol]==1 &&  vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        grid[nrow][ncol]=2;
                        rotten.add(new Pair(nrow,ncol));

                    }
                }



            }
            if(rotten.size()!=0){
                q.add(rotten);
                time++;
            }



        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return time;
    }

}
