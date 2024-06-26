package Graph;

public class Flood_fill_Algorithm
{
    //An image is represented by a 2-D array of integers, each integer representing the pixel value of the image.
    //Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill,
    // and a pixel value newColor, "flood fill" the image.
    //To perform a "flood fill", consider the starting pixel,
    // plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
    // plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel),
    // and so on. Replace the color of all of the aforementioned pixels with the newColor.
    class Solution
    {
        public void DFS(int res[][],int sr,int sc,int newColor,boolean vis[][],int x)
        {
            int n=res.length;
            int m=res[0].length;
            if(sr>=n||sr<0||sc>=m||sc<0||res[sr][sc]!=x)
                return;
            if(!vis[sr][sc]&&res[sr][sc]==x){
                vis[sr][sc]=true;
                res[sr][sc]=newColor;
                DFS(res,sr,sc-1,newColor,vis,x);
                DFS(res,sr,sc+1,newColor,vis,x);
                DFS(res,sr-1,sc,newColor,vis,x);
                DFS(res,sr+1,sc,newColor,vis,x);
            }
        }
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
        {
            // Code here
            int n=image.length;
            int m=image[0].length;
            int [][]res=new int [n][m];
            boolean [][] vis=new boolean[n][m];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    res[i][j]=image[i][j];
                }
            }
            int x=res[sr][sc];

            DFS(res,sr,sc,newColor,vis,x);

            return res;
        }
    }
}
