public class SLLDeleteLast
{
    private ListNode head;
    public static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data)
        {
            this.data=data;
        }
    }
    public void display(){
        ListNode current =head;
        while(current!=null)
        {
            System.out.println(current.data+"-->");
            current=current.next;
        }
        System.out.println("null");
    }

    public void insert(int position,int value){
        ListNode node=new ListNode(value);
        if(position==1)
        {
            node.next=head;
            head=node;
        }
        else {
            ListNode previous=head;
            int count=1;
            while(count<position-1)
            {
                previous=previous.next;
                count++;
            }
            ListNode current=previous.next;
            previous.next=node;
            node.next=current;
        }
    }

    public ListNode DeleteLast()
    {
        if(head==null||head.next==null)   //basically list have only one node
            return head;
        else {
            ListNode current=head;
            ListNode previous=null;
            while(current.next!=null)
            {
                previous=current;
                current=current.next;
            } //as loop iterate completely previous points second lasat node
            previous.next=null;  //breaks the chain
            return current;  //return free node
        }

    }
    public static void main(String[] args) {
        SLLDeleteLast sll=new SLLDeleteLast();
        sll.insert(1,67);
        sll.insert(2,4);
        sll.insert(3,35);
        sll.insert(4,23);
        sll.insert(5,55);

        System.out.println(+sll.DeleteLast().data+"\n");
        sll.display();

    }
}
