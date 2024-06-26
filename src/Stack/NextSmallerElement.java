package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement
{
    public static void main(String[] args)
    {
        int arr[]={5,3,1,5,4};
        System.out.println(Arrays.toString(nextSmallerElement(arr)));

        System.out.println(Arrays.toString(findSmallerElement2(arr)));
    }
    static int[]  nextSmallerElement(int arr[])
    {
        int res[]=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            if (!stack.isEmpty())
            {
                while (!stack.isEmpty()&&stack.peek()>=arr[i])
                {
                    stack.pop();
                }
            }

            if (stack.isEmpty())
                res[i]=-1;
            else {
                res[i]=stack.peek();
            }
            stack.push(arr[i]);

        }
        return res;

    }

    static int[] findSmallerElement2(int arr[])
    {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int ans[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--)
        {
            int curr=arr[i];
            while(stack.peek()>=curr)
            {
                stack.pop();
            }
            //means jab tak chota nahi milta tab tak pop karte jao jaise hi chota mil jaye loop se bahar aa jayenge
            ans[i]=stack.peek(); //means chota element mil gaya hai
            stack.push(curr);
        }
        return ans;

    }
}
