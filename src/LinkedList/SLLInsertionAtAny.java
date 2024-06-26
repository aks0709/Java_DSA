public class SLLInsertionAtAny
{
    private ListNode head;
    public static class ListNode
    {
        private int data;
        private ListNode next;

        public ListNode(int data)
        {
            this.data=data;
        }
    }
    public void insert(int position,int value){
        ListNode node=new ListNode(value);
        if(position==1)
        {
            //currently node points null
            node.next=head; //node will starting point node that head is pointing
            head=node; //head starting point this node
        }
        else{
            ListNode previous=head;  //previous termed node is node that is just before node to be entered
            int count=1;
            while(count<position-1){   //traversing for previous to start pointing a node before node to be entered
                previous=previous.next;
                count++;
            }
            ListNode current=previous.next;  //use to store reference of node just after the node to be entered
            previous.next=node; //creating a link
            node.next=current; // "         "  "
        }
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
     SLLInsertionAtAny s1=new SLLInsertionAtAny();
     s1.insert(1,3);
     s1.display();
    }

}
