package Queue;
//maybe wrong
public class DoublyEndedQueue
{
    int arr[];
    int front=-1;
    int rear=-1;
    int size;
    public DoublyEndedQueue(int n)
    {
        this.size=n;
        arr=new int[size];
    }
    public boolean isFull(){
        if (front==(rear+1)%size)
            return true;
        else
            return false;
    }
    public boolean isEmpty()
    {
        if (front==-1&&rear==-1)
            return true;
        else
            return false;
    }
    public void enqueueFront(int data)
    {

        if (isFull())
        {
            System.out.println("Queue is Full");
            return;
        }
        else if (front==-1)
        {
            front=rear=0;
        }
        else if (front==0)
        {
            front=size-1;
        }
        else
        {
            front--;
        }
        arr[front]=data;

    }

    public void enqueueRear(int data)
    {

        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }

        if (front==-1)
        {
            front=0;
        }
        rear=(rear+1)%size;
        arr[rear]=data;

    }
    public int dequeueFront()
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

    public int dequeueRear()
    {
        if (isEmpty())
        {
            System.out.println("QUEUE IS EMPTY");
            return -1;
        }

        int res=arr[rear];
        //single element
        if (front==rear) {
            front = -1;
            rear = -1;
        }
        else if (rear==0)
        {
            rear=size-1;
        }
        else
        {
            rear--;
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
    public int peek2()
    {
        if(isEmpty())
        {
            System.out.println("QUEUE IS EMPTY");
            return -1;
        }

        return arr[rear];
    }

    public static void main(String[] args)
    {
        DoublyEndedQueue deq=new DoublyEndedQueue(5);
        /*deq.enqueueRear(30);
        deq.enqueueRear(60);
        deq.enqueueRear(70);
        deq.enqueueRear(50);
        deq.enqueueRear(30);*/
        deq.enqueueFront(10);
        deq.enqueueFront(70);
        deq.enqueueFront(30);
        deq.enqueueFront(50);
        deq.enqueueFront(80);
        while (!deq.isEmpty())
        {
            System.out.print(deq.peek()+" ");
            deq.dequeueFront();
        }

    }
}
