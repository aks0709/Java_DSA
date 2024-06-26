package Stack;

import java.util.EmptyStackException;

public class stack
{
    //instance variables

    private ListNode top;  //used to point top node of stack
    private int length;   //represent length of stack
    private class ListNode
    {
        private int data;
        private ListNode next;
        public ListNode(int data) {
            this.data = data;

        }
    }

    public int length()  //return length of string
    {
        return length;
    }

    public boolean isEmpty()  //tell weather stack is empty or not
    {
        return length==0;
    }

    public stack ()  //initialising stack with top pointing null and length =0
    {
        top =null;
        length=0;
    }
public void push(int data)  //this method is used to insert data into stack
{
    ListNode temp=new ListNode(data);
    temp.next=top;
    top=temp;
    length++;
}

public int pop()  //this method is used to take data out of stack and hence length reduces
{
    if (isEmpty())
        throw new EmptyStackException();

    int result=top.data;
    top=top.next;
    length--;

    return result;

}
public int peek()  //this method simply peek into the stack and take top node data
{
    if (isEmpty())
        throw new EmptyStackException();

    return top.data;
}
public void displayStack()
{
    ListNode temp=top;
    while(temp!=null)
    {
        System.out.println(temp.data);
        temp=temp.next;
    }
}
public int MidNode(){
        if (isEmpty())
            throw new EmptyStackException();

        ListNode slowptr=top;
        ListNode fastptr=top;
        while(fastptr!=null&&fastptr.next!=null)
        {
            slowptr=slowptr.next;
            fastptr=fastptr.next.next;
        }

        return slowptr.data;
}

    public static void main(String[] args) {
        stack S=new stack();  //a stack is created with top pointing to null and length =0
        S.push(10);
        S.push(14);
        S.push(20);
        S.push(44);
        System.out.println(S.peek());
        S.pop(); //remove last inserted node
        System.out.println(S.peek()); // now it represent the new last node
        S.push(59);
        S.push(23);
        System.out.println(S.peek());
        S.pop();
        System.out.println(S.peek());
        System.out.println("\n");
        S.displayStack();
        System.out.println("\n"+S.MidNode());
        S.push(35);
        System.out.println("\n");
        S.displayStack();
        System.out.println("\n"+S.MidNode());

    }
}
