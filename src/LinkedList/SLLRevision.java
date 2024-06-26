package LinkedList;

public class SLLRevision
{
    private ListNode head;
    private static class ListNode  //we create an entity with the help of class
    {
        private int data;   // entity has data part
        private ListNode next;  //and next part which point to different ListNode thats why its type is ListNode

        public ListNode(int data) //a constructor that is used to take data in the Node
        {
            this.data=data;
        }
    }

    public void display()
    {
        ListNode current=head;
        while(current!=null)
        {
            System.out.print(current.data+"-->");
            current=current.next;
        }
        System.out.print("null");
    }

    public void display(ListNode head)
    {
        ListNode current=head;
        while(current!=null)
        {
            System.out.print(current.data+"-->");
            current=current.next;
        }
        System.out.print("null");
    }

    public void insertFirst(int value)
    {
        ListNode newNode=new ListNode(value);
        newNode.next=head;  //newnode starting pointing previous head
        head=newNode;   // then head start pointing newNode
    }

    public void insertAtPosition(int value,int position)
    {
        ListNode node = new ListNode(value);
        if (position==1)
        {
            node.next=head;
            head=node;
        }
        else{
        ListNode previous = head;
        int count = 1;
        while (count < position - 1)  //we have to traverse to reach the node just before the position for breaking linkage
        {
            previous = previous.next;
            count++;
        }

        //if we directly do previous.next=node we are going to loose remaing of list
        ListNode current = previous.next;//we make a node with name current that points the remaining list
        node.next = current;
        previous.next = node;
    }
    }

    public void insertLast(int value)
    {
        ListNode newNode=new ListNode(value);
        if (head==null)   //edge case when list contain no node
        {
            head=newNode;
            return;
        }
        ListNode current=head;
        while(current.next!=null)
        {
            current=current.next;
        }


        current.next=newNode;
        newNode.next=null;
    }

    public ListNode DeleteFirst()  //we are freeing the space why returning the deleted node
    {
        ListNode temp=head;
        if (head==null)  //means list is empty
            return null;

          head=head.next;
          temp.next=null;
        return temp;
    }

    public ListNode DeleteLast()
    {
        if (head==null||head.next==null) //means list contain no node or single node
            return head;   //return head simply
        else {
            ListNode current=head;
            ListNode previous=null;
            while(current.next!=null)
            {
                previous=current;
                current=current.next;
            }  //at the end of the loop previous points seconf last node and current points last node
            previous.next=null;
            return current;
        }
    }

    public void DeleteAtPosition(int position)  //we made this method of return type void
    {
        if(position==1)
            head=head.next;  //simply the first node go to garbage
        else {
            ListNode previous=head;
            int count=1;
            while (count<position-1)
            {
                previous=previous.next;  //traverse till the node before the node that is to be deleted
                count++;
            }
            //breaking linkage
            ListNode current=previous.next;
            previous.next=current.next;
        }

    }

    public boolean search(int key)
    {
        if (head==null)  //empty list
            return false;

        ListNode current=head;
        while(current!=null)
        {
            if (current.data==key)
                return true;

            current=current.next;
        }
        return false;  //if we found element we simply break out of loop ,we encounter this return statement only when loop runs fully ,so element not found
    }
    public ListNode reverse(ListNode head)
    {
        ListNode current=head;
        ListNode next=null;   //this will move ahead of current and help current to move forward
        ListNode previous=null;  //this is used to hold previous links
        while(current!=null)
        {
            next=current.next; //we make next to start pointing to the next node just after the current node
            current.next=previous; //current points to the "previous" node
            previous=current;  //previous moves forward
            current=next;  //current moves forward

            //after 1st step again next is ahead of current pointer and previous hold the previous links
        }
        return previous;

    }

    public ListNode getMidNode(ListNode head)
    {
        if(head==null)
        {
            return null;
        }
        else{
        ListNode slowptr = head;
        ListNode fastptr = head;
        while (fastptr != null && fastptr.next != null)  //since fastptr moves two node at a time so we need to check weather fastptr.next==null or not
        {
            slowptr = slowptr.next;        // slowptr moves at usual speed
            fastptr = fastptr.next.next;  //fastptr moves at twice speed
        }
            return slowptr;
    }

    }
    public static void main(String[] args)
    {
        SLLRevision sll=new SLLRevision();  //we make an object of class Singly Linked List i.e, sll
     sll.head=new ListNode(10);  //we call instance variable head with the help of object
     ListNode sec=new ListNode(5);
        ListNode third=new ListNode(15);
        ListNode fourth=new ListNode(53);
        ListNode fifth=new ListNode(25);
        ListNode sixth=new ListNode(58);
        sll.head.next=sec;
        sec.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;

        sll.insertFirst(34);
        sll.insertLast(69);
        sll.insertAtPosition(12,1);
        sll.insertAtPosition(121,5);
        sll.DeleteFirst();
        sll.DeleteLast();
        sll.DeleteAtPosition(4);
        sll.display(); //we call display method with the help of object sll
        System.out.println("\n");
        ListNode midNode=sll.getMidNode(sll.head);
        System.out.println(midNode.data);
        if (sll.search(115))
            System.out.println("element found");
        else
            System.out.println("element not found");
        ListNode reverseSLLHead=sll.reverse(sll.head);
        sll.display(reverseSLLHead);

    }
}
