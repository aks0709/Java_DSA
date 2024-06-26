package LinkedList;

public class SinglyLinkedList
{
    private ListNode head;//global
    private static class ListNode
    {
        private int data;   //generic types
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }

    }
    public void insert(int position,int value){
        ListNode node=new ListNode(value);
        if(position==1)
        {
            node.next=head;
            head=node;
        }
        else{
            ListNode previous=head;
            int count=1;
            while(count<position-1){
                previous=previous.next;
                count++;
            }
            ListNode current=previous.next;
            previous.next=node;
            node.next=current;
        }
    }

    public void insertfirst(int value)
    {
        ListNode newNode=new ListNode(value);
        newNode.next=head;
        head=newNode;
    }

    public int length(){
        if(head==null)
            return 0;


        int count=0;
        ListNode current=head;
        while (current.next!=null)
        {
            current=current.next;
            count++;
        }
        return count;
    }


    public void display()
    {
        ListNode current=head;
        while(current!=null)
        {
            System.out.println(current.data+"-->");
            current=current.next;
        }
        System.out.println("null");
    }



    public static void main(String[] args)
    {
        SinglyLinkedList sll=new SinglyLinkedList();
       // sll.head=new ListNode(10);
        //ListNode second=new ListNode(1);
        //ListNode third=new ListNode(8);
        //ListNode fourth=new ListNode(11);

        //now connecting every node
        //sll.head.next=second;   //10-->1
        //second.next=third;      //10-->1-->8
        //third.next=fourth;      //10-->1-->8-->11-->NULL


        //printing elements of singlylinkedlist
          //                 sll.display();
        //length function calling
        //System.out.println("Length is:- "+sll.length());

           // sll.insertfirst(11);
            //sll.insertfirst(1);
           // sll.insertfirst(13);
            //sll.insertfirst(2);
             //sll.display(); // link list print hogi 2-->13-->1-->11   becoz we are inserting node at first position
            sll.insert(1,3);
            sll.display();

    }
}
