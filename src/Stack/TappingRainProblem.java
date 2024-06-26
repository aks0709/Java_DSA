package Stack;

import java.util.Stack;

public class TappingRainProblem
{
    public static void main(String[] args)
    {
        int arr[]={4,2,0,3,2,5};
        System.out.println(WaterTrap(arr));


    }
    static int WaterTrap(int height[])
    {
        int next[]=nextGreaterBar(height);
        int prev[]=prevGreaterBar(height);
        int waterTapped1=0;
        int waterTapped2=0;
        for (int i=0;i< height.length;i++)
        {
            if (next[i]>= prev[i]&&(next[i]!=height.length&&prev[i]!=-1))
            {
                int length=height[prev[i]];
                int breadth=next[i]-prev[i]-1;
                int TotalWaterTapped=length*breadth;
                for (int j=prev[i]+1;j<next[i];j++)
                {
                    TotalWaterTapped=TotalWaterTapped- height[j];
                }
                waterTapped1=waterTapped1+TotalWaterTapped;
            }

            if (next[i]<= prev[i]&&(next[i]!=height.length&&prev[i]!=-1))
            {
                int length=height[next[i]];
                int breadth=next[i]-prev[i]-1;
                int TotalWaterTapped=length*breadth;
                for (int j=next[i]-1;j>prev[i];j--)
                {
                    TotalWaterTapped=TotalWaterTapped- height[j];
                }
                waterTapped2=waterTapped2+TotalWaterTapped;
            }
        }
        return (waterTapped1+waterTapped2);
    }

    static int[] nextGreaterBar(int[] arr)
    {
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[arr.length];
        for(int i= arr.length-1;i>=0;i--)
        {
            if (!stack.isEmpty())
            {
                while (!stack.isEmpty()&&(arr[stack.peek()]<arr[i]))
                {
                    stack.pop();
                }
            }
            if (stack.isEmpty())
            {
                res[i]= arr.length;
            }
            else
            {
                res[i]=stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
    static int[] prevGreaterBar(int[] arr)
    {

        Stack<Integer> stack=new Stack<>();
        int res[]=new int[arr.length];
        for(int i= 0;i< arr.length;i++)
        {
            if (!stack.isEmpty())
            {
                while (!stack.isEmpty()&&(arr[stack.peek()]<arr[i]))
                {
                    stack.pop();
                }
            }
            if (stack.isEmpty())
            {
                res[i]=-1;
            }
            else
            {
                res[i]=stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}
