package Graph.Revision;

import java.util.LinkedList;
import java.util.Queue;
public class FloodFill_BFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here

        int n=image.length;
        int m=image[0].length;
        int iniColor=image[sr][sc];
        Queue<Pair> q=new LinkedList<Pair>();

        image[sr][sc]=newColor;
        q.add(new Pair(sr,sc));

        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1};

        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.poll();
            for(int i = 0;i<4;i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol < m &&
                        image[nrow][ncol] == iniColor && image[nrow][ncol] != newColor) {
                    image[nrow][ncol]=newColor;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
        return image;
    }
}
