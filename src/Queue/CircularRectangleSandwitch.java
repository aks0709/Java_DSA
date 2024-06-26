package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CircularRectangleSandwitch {
    public static void main(String[] args)
    {
        int arr1[]={1,0,0,0,1,1};
        int arr2[]={1,1,1,0,0,1};
        int ans=NoOfStudentUnableToEat(arr1,arr2);
        System.out.println(ans);

    }
    static int NoOfStudentUnableToEat(int sandwiches[],int students[]) {
        Queue<Integer> queue=new LinkedList<>();
        Stack<Integer> stack=new Stack<>();
        for (int i:students)
     {
         queue.add(i);
     }
        for (int i=sandwiches.length-1;i>=0;i--)
        {
            stack.push(sandwiches[i]);
        }
        while (!queue.isEmpty())
        {
            if (!stack.isEmpty()&&stack.peek()==queue.peek())
            {
                stack.pop();
                queue.remove();
            }
            else if(stack.isEmpty())
                return 0;
            else
            {
                int CurrentSize=queue.size();
                int count=0;
                while(queue.peek()!=stack.peek())
                {
                    count++;
                    queue.add(queue.remove());
                    if (CurrentSize==count)
                        return CurrentSize;
                }
            }
        }
        return queue.size();
    }
}
