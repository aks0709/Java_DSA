package PP.RecursionDay3;

import java.util.Arrays;

public class BalancedParenthesis {
   public  static void GenerateParenthesis(char arr[],int index,int op,int cl,int N){
        if(op==N&&cl==N) {
            for(char c: arr){
                System.out.print(c+" ");
            }
            System.out.println();
            return;
        }
        if(op==cl){
            arr[index]='(';
            GenerateParenthesis(arr,index+1,op+1,cl,N);
        }
        else{
            if(op==N)
            {
                arr[index]=')';
                GenerateParenthesis(arr,index+1,op,cl+1,N);
            }
            else{
                arr[index]='(';
                GenerateParenthesis(arr,index+1,op+1,cl,N);
                arr[index]=')';
                GenerateParenthesis(arr,index+1,op,cl+1,N);
            }
        }
    }
    public static void main(String[] args) {
       char arr[]=new char[6];
        GenerateParenthesis(arr,0,0,0,3);
    }
}
