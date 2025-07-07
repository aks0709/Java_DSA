package Graph.Revision;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
public class NoOfConnectedComponent {
    //BFS function
    public static void bfs(int ro,int co,int vis[][],char grid[][]){
        vis[ro][co]=1;
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(ro,co));
        int n= grid.length;
        int m=grid[0].length;
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.poll();
            for(int delRow=-1;delRow<=1;delRow++){
                for(int delCol=-1;delCol<=1;delCol++){
                    int nRow=row+delRow;
                    int nCol=col+delCol;
                    //check feasibility and is visited or not
                    if(nRow>=0&&nRow<n  &&nCol>=0&&nCol<m   &&vis[nRow][nCol]==0  && grid[nRow][nCol]=='1'){
                        vis[nRow][nCol]=1;
                        q.add(new Pair(nRow,nCol));
                    }
                }
            }
        }
    }

    //function to count no of island
    public static int numIslands(char grid[][]){
        int count=0;
        int n= grid.length;
        int m=grid[0].length;
        //create a visited array
        int vis[][]=new int[n][m];
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(vis[row][col]==0 && grid[row][col]=='1'){
                        count++;  //means it is another starting point of another island
                        //call bfs for new island
                    bfs(row,col,vis,grid);

                }
            }
        }


        return count;
    }
    public static void main(String[] args) {
        char grid[][]={{'0','1','1','0'},{'0','1','1','0'},{'0','0','1','0'},{'0','0','0','0'},{'1','1','0','1'}};
        System.out.println(numIslands(grid));
    }
}
