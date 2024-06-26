//package Stack;
//https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1

import java.util.Stack;

/*public class CelebrityProblem
{
    public static void main(String[] args)
    {
        int arr[][]=
                {
                        {0,1,0},{0,0,0},{0,1,0}
        };
        System.out.println(celebrity(arr, arr.length));

    }
    static int celebrity(int M[][], int n)
    {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(M[i][j]==1&&(i!=j))
                {
                    stack.push(i);
                }
            }
        }
        for(int j=0;j<n;j++)
        {
                while(M[j][stack.peek()]!=0)
                {
                    stack.pop();
                }
        }
        if (stack.isEmpty())
            return -1;
        else
        return stack.peek();

    }
}
*/