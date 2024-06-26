package PP.BackTrackingDay4;

public class NQueen {
    public static void solveNQueen(char[][] arr,int r){
        if(r==arr.length)
            return;

        for(int col=0;col<arr[0].length;col++){
            if(isSafe(arr,r,col)){
                arr[r][col]='Q';
                solveNQueen(arr,r+1);
                arr[r][col]='.';
            }
        }
    }
   public static boolean  isSafe(char[][] arr,int r,int c){
        //for checking upward
        for(int i=r,j=c;i>=0;i--)
        {
            if(arr[i][j]=='Q');
            return false;
        }
        //check left diagnol
       for(int i=r,j=c;i>=0&&j>=0;i--,j--){
           if(arr[i][j]=='Q')
               return false;
       }

       //check right diagnol
       for(int i=r,j=c;i>=0&&j<arr[0].length;i--,j++){
           if(arr[i][j]=='Q')
               return false;
       }

       return true;
   }
    public static void main(String[] args) {
      int N=4;
      char arr[][]=new char[4][4];
      for(int i=0 ;i <N;i++){
          for(int j=0;j<N;j++){
              arr[i][j]='.';
          }
      }
      solveNQueen(arr,0);
        for(int i=0 ;i <N;i++){
            for(int j=0;j<N;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }


    }
}
