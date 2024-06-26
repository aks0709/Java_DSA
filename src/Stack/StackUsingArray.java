package Stack;

public class StackUsingArray
{
    //stack is created with a instance variable top that points to current block in stack
    //sizwe and array should
    private int top;

    int size=6;
    int arr[]=new int[size];


    public boolean isEmpty()
    {
        return top<0; //if top is less than zero than return false
    }
    public StackUsingArray()  //constructor :-initialize stack with top pointing -1
    {
        top=-1;
    }
    public void push(int data)
    {
     if(top==size-1)  //stack is full
         System.out.println("case of overflow");

     top++;
     arr[top]=data;

    }

    public void pop()
    {
        if(top==-1)  //stack is empty
            System.out.println("case of underflow");

        top--;

    }

    public int peek()
    {
        if(top==-1)
            System.out.println("stack is empty");

        return arr[top];
    }

    public void display()
    {
        for(int i=top;i>=0;i--)
        {
            System.out.println(arr[i]);
        }
    }



    public static void main(String[] args)
    {
        StackUsingArray s=new StackUsingArray();
        s.push(10);
        s.push(12);
        s.push(43);
        s.push(35);
        s.display();
        System.out.println("\n");
        s.push(45);
        s.display();
        System.out.println("\n");
        s.push(23);
        s.display();
        System.out.println("\n");
        s.pop();
        s.display();
        System.out.println("\n");

        System.out.println(s.peek());
    }

}
