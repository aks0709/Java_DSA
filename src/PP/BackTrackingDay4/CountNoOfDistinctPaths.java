package PP.BackTrackingDay4;

public class CountNoOfDistinctPaths {
    public static void CountPaths(int vis[][],int rd,int cd,int r,int c,int count) {
        if (r == rd && c == cd) {
            count++;
            return;

        }

        //Left
        /*if(isValid(i,j-1)&&!vis[i][j-1]{
        Vis[i][j-1]=1;
        CP(vis,i,j-1);
        vis[i][j-1]=0;
    */
        //Top

        //Right

        //Down
    }
    public static void main(String[] args) {
    int rs=1;
    int cs=1;
    int ds=0;
    int cd=2;
    int vis[][]=new int[3][3];
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++)
        {
            vis[i][j]=0;
        }
    }
    vis[rs][cs]=1;
    }
}
