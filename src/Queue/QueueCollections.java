package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueCollections
{
    public static void main(String[] args)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.remove();
        while(!q.isEmpty())
        {
            System.out.print(q.peek()+" ");
            q.remove();
        }
        Deque<Integer> deque=new ArrayDeque<>();
        deque.addFirst(10);
        deque.addLast(11);
        deque.addFirst(54);
        deque.addLast(63);
        deque.addLast(51);
        deque.addFirst(45);
        deque.pollLast();
        System.out.println("\n");
        while (!deque.isEmpty())
        {
            System.out.print(deque.peek()+" ");
            deque.remove();
        }


    }
}
