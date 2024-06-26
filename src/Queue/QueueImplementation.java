package Queue;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class QueueImplementation
{
    private ListNode front;
    private ListNode rear;
    private int length;
    private class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data)
        {
            this.data=data;
        }
    }
    public QueueImplementation()
    {
        this.front=null;
        this.rear=null;
        length=0;
    }
    public int length()
    {
        return length;
    }
    public boolean isEmpty()
    {
        return length==0;
    }
    public void  print()
    {
        if (isEmpty())
            return;

        ListNode current=front;
        while (current!=null)
        {
            System.out.print(current.data+"-->");
            current=current.next;
        }
        System.out.print("NULL\n");
    }
    public void enqueue(int data)
    {
        ListNode temp=new ListNode(data);
        if (isEmpty())
            front=temp;
        else {
            rear.next=temp;
        }
        rear=temp;
        length++;
    }
    public int first()
    {
        if (isEmpty())
            throw new NoSuchElementException();

        return front.data;
    }

    public int last()
    {
        if (isEmpty())
            throw new NoSuchElementException();

        return rear.data;
    }

    public int dequeue()
    {
        if (isEmpty())
            throw new NoSuchElementException();

            int res=front.data;
            front=front.next;
            if (front==null)
                rear=null;

        length--;
        return res;
    }

    public static void main(String[] args) {
        QueueImplementation queue=new QueueImplementation();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.print();
        queue.dequeue();
        queue.print();
        System.out.print("first="+queue.first()+" last="+queue.last()+"\n");
        queue.dequeue();
        queue.print();
        System.out.print("first="+queue.first()+" last="+queue.last()+"\n");

        queue.dequeue();
        queue.print();
        System.out.print("first="+queue.first()+" last="+queue.last()+"\n");

        queue.dequeue();
        queue.print();


    }
}
