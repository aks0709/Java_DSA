package Queue;

public class QueueUsingArray
{
    private int front;
    private int rear;
    private int size=10;
    private int arr[]=new int[size];
    public QueueUsingArray()
    {
        this.front=0;
        this.rear=0;
    }
    public boolean isEmpty()
    {
        return (front==rear);
    }
    public int getFront()
    {
        if (isEmpty())
            return -1;
        else
            return arr[front];
    }
    public int getrear()
    {
        if (isEmpty())
            return -1;
        else
            return arr[rear-1];
    }
    public void enqueue(int data)
    {
        if (rear==size-1)
            System.out.println("queue overflow");
        else {
            arr[rear] = data;
            rear++;
        }
    }
    public void dequeue()
    {
        if (isEmpty())
            System.out.println("queue is empty");
        else {
            arr[front]=-1;
            front++;
            if(front==rear)
            {
                front=0;
                rear=0;
            }
        }
    }
    public void display()
    {
        if (isEmpty())
            System.out.println("Empty Queue");

        int current=front;
        while(current!=rear)
        {
            System.out.print(arr[current]+"---");
            current++;
        }
    }



    public static void main(String[] args)
    {
        QueueUsingArray queue=new QueueUsingArray();
        queue.enqueue(15);
        queue.enqueue(25);
        queue.enqueue(35);
        queue.enqueue(45);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(20);
        System.out.println(queue.getFront());
        System.out.println(queue.getrear());


    }

}
