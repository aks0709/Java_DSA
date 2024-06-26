package Queue;

public class CircularQueue
{
    private int front=-1;
    private int rear=-1;
    private int size;
    private int arr[];
    public CircularQueue(int n)
    {
        this.size=n;
        arr=new int[n];
        front=-1;
        rear=-1;
    }

    public boolean isEmpty()
    {
        if (front<0)
            return true;
        else return false;
    }
    public boolean isFull()
    {
        if ((rear+1)%size==front)
            return true;
        else return false;
    }
    /*public void display()
    {
        if (isEmpty())
            System.out.println("Empty Queue");

        int current=front;
        while(current!=rear)
        {
            System.out.print(arr[current]+"---");
            current++;
        }
    }*/
    public void enqueue(int data)  //O(1)
    {
        if (isFull())//queue is full
        {
            System.out.println("QUEUE IS FULL");
            return;
        }
        if (front==-1) //first element
        {
            front=0;
        }
        rear=(rear+1)%size;
        arr[rear]=data;
    }
    public int  dequeue()  //O(1)
    {
        if (isEmpty())
        {
            System.out.println("QUEUE IS EMPTY");
            return -1;
        }

        int res=arr[front];
        //single element
        if (front==rear)
        {
            front=-1;
            rear=-1;
        }
        else {
            front=(front+1)%size;

        }
        return res;
    }
    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("QUEUE IS EMPTY");
            return -1;
        }

        return arr[front];
    }
    public static void main(String[] args)
    {
        CircularQueue cq=new CircularQueue(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);
        System.out.println(cq.dequeue());
        cq.enqueue(60);
        System.out.println(cq.dequeue());
        cq.enqueue(70);
        System.out.println("\n");
        while (!cq.isEmpty())
        {
            System.out.println(cq.peek());
            cq.dequeue();
        }



    }
}
