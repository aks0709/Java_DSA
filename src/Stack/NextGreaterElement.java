package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement
{
    public static void main(String[] args)
    {
        int arr[]={4,7,3,4,8,1};
        System.out.println(Arrays.toString(nextGreaterElement(arr)));

    }

    public static int [] nextGreaterElement(int arr[])
    {
        int result[]=new int[arr.length];
        Stack<Integer> s=new Stack<>();
        for (int i=arr.length-1;i>=0;i--)
        {
            if (!s.isEmpty())  // if our stack is not empty we met this condition
            {
                while (!s.isEmpty()&&s.peek()<=arr[i]) //if s.peek element is less than arr[i] ,that element is of no use
                {
                    s.pop();//simply discard it
                }//this while loop runs till any of the condition is false
                //if stack become empty it means no greater element in the right
                //if s.peek>=arr[i] it means we got our answer
            }

            if (s.isEmpty())  //suppose stack become empty or already empty
            {
                result[i]=-1;  //it means there is no element in stack for comparisons
                //in  other word there is no greater element in the right

            }
            else
            {
                result[i]=s.peek(); //reason line no 31
            }
            s.push(arr[i]);  //current element is pushed in stack for further comparisons
        }
        return result;

    }
}
