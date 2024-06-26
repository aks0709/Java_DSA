package Stack;

import java.util.Stack;

public class LargestAreaInHistogram
{

    public static void main(String[] args)
    {
        int arr[]={2,2,2,2,2,2,2};
        System.out.println(Area(arr));

    }
    static int Area(int arr[])
    {
        int next[]=nextSmallerElementIndex(arr);
        int prev[]=PreviousSmallerElementIndex(arr);
        int area=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++)
        {
            int length=arr[i];
            int breadth=next[i]-prev[i]-1;  //it gives you complete breadth for current arr[i]/height
            int NewArea=length*breadth;
            if(NewArea>=area)
            {
                area=NewArea;
            }
        }
        return area;
    }
    static int[]  nextSmallerElementIndex(int arr[])  //gives you array that store next smaller Element's index
    {
        int res[]=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            if (!stack.isEmpty())
            {
                while (!stack.isEmpty()&&arr[stack.peek()]>=arr[i])
                {
                    stack.pop();
                }
            }

            if (stack.isEmpty())
                res[i]=arr.length;  //suppose we didnt get get the next smaller element,eg{2,2,2,2,2} so in that case breadth cannot be -1 so breadth=arr.length
            else {
                res[i]=stack.peek();
            }
            stack.push(i);
        }
        return res;

    }
    static int[]  PreviousSmallerElementIndex(int arr[])  //gives you array that store previous smaller Element's index
    {
        int res[]=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<= arr.length-1;i++)
        {
            if (!stack.isEmpty())
            {
                while (!stack.isEmpty()&&arr[stack.peek()]>=arr[i])
                {
                    stack.pop();
                }
            }

            if (stack.isEmpty())
                res[i]=-1;
            else {
                res[i]=stack.peek();
            }
            stack.push(i);

        }
        return res;

    }
}
