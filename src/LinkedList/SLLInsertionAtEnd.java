public class SLLInsertionAtEnd
{
    private ListNode head;
    public static class ListNode{

        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data=data;
        }
    }

    public void InsertLast(int value){
        ListNode newNode=new ListNode(value);
        if(head==null)
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
        SLLInsertionAtEnd s1=new SLLInsertionAtEnd();
        s1.head=new ListNode(10);
        ListNode second=new ListNode(21);
        ListNode third =new ListNode(12);
        ListNode fourth=new ListNode(34);

        s1.head.next=second;
        second.next=third;
        third.next=fourth;
        s1.InsertLast(88);
        s1.InsertLast(69);
        s1.display();
    }
}
