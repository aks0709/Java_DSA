package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    public static void main(String[] args)
    {
        StackUsingQueue stack=new StackUsingQueue();
        stack.push(10);
        stack.push(20);
        stack.push(40);
        stack.push(30);
        stack.push(70);
        stack.push(90);
        stack.pop();
        while (!stack.isEmpty())
        {
            System.out.print(stack.peek()+" ");
            stack.pop();
        }

    }
    static Queue<Integer> queue1=new LinkedList<>();
    static Queue<Integer> queue2=new LinkedList<>();
    public boolean isEmpty()
    {
        return queue1.isEmpty()&&queue2.isEmpty();
    }
    public void push(int data)
    {
        while (!queue1.isEmpty())
        {
            queue2.add(queue1.remove());
        }
        queue1.add(data);
        while (!queue2.isEmpty())
        {
            queue1.add(queue2.remove());
        }
    }
    public int pop()
    {
        if (queue1.isEmpty())
            return -1;

        return queue1.remove();
    }
    public int peek()
    {

        if (queue1.isEmpty())
            return -1;

        return queue1.peek();
    }
}
