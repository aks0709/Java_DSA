import java.util.NoSuchElementException;

public class DoublyLinkedList
{
    private ListNode head;
    private ListNode tail;
    private int length;
    public static class ListNode{
        private int data;
        private ListNode next;
        private ListNode previous;
        public ListNode(int data)
        {
            this.data=data;
        }
    }
    public DoublyLinkedList(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public int length(){
        return length;
    }
     public void displayforward(){
        if(head==null)
            return;
        ListNode temp=head;
        while(temp!=null){
            System.out.println(temp.data+"-->");
            temp=temp.next;
        }
         System.out.println("null");
     }

     public void displaybackward(){
        if(tail==null)
            return;
        ListNode temp=tail;
        while(temp!=null)
        {
            System.out.println(temp.data+"-->");
            temp=temp.previous;
        }
         System.out.println("null");
     }

     public void display_spiral()
     {
         if (length==0)
             return;

      ListNode temp1=head;
      ListNode temp2=tail;
      int count=0;
      while(temp1!=temp2&&count<length/2)
      {
          System.out.println(temp2.data+"-->");
          System.out.println(temp1.data+"-->");
          temp2=temp2.previous;
          temp1=temp1.next;
          count++;
      }
      if (temp1==temp2)
      {
          System.out.println(temp1.data+"-->");
      }
         System.out.println("null");
     }
     public void insertfirst(int value){
      ListNode newnode=new ListNode(value);
        if(isEmpty())
            tail=newnode;
        else {
            head.previous=newnode;
        }
        newnode.next=head;
        head=newnode;
        length++;
     }

     public ListNode deletefirst(){
        if (isEmpty())
            throw new NoSuchElementException();
        ListNode temp=head;
        if (head==tail)
        {
            tail=null;
        }
        else{
            head.next.previous=null;
        }
        head=head.next;
        temp.next=null;
        return temp;
     }
     public ListNode deletelast(){
        if (isEmpty())
            throw new NoSuchElementException();
        ListNode temp=tail;
        if(head==tail)
            head=null;
        else {
            tail.previous.next=null;
        }
        tail=tail.previous;
        temp.previous=null;
        return temp;
     }
     public void insertlast(int value){
        ListNode newnode=new ListNode(value);
        if (isEmpty())
            head=newnode;
        else{
            tail.next=newnode;
            newnode.previous=tail;
        }
        tail=newnode;
        length++;
     }
    public static void main(String[] args) {
        DoublyLinkedList dll=new DoublyLinkedList();
        //dll.insertfirst(8);
        dll.insertfirst(7);
        dll.insertfirst(6);
        dll.insertfirst(5);
        dll.insertfirst(4);
        dll.insertfirst(3);
        dll.insertfirst(2);
        dll.insertfirst(1);
        //dll.insertfirst(4);
        //dll.insertlast(12);
        System.out.println("forward display");
        dll.displayforward();
        //System.out.println("backward display");
        //dll.displaybackward();
        System.out.println("display in spiral manner");
        dll.display_spiral();
        //dll.deletefirst();
        //dll.deletelast();
       // dll.displayforward();
       // dll.displaybackward();
    }
}
