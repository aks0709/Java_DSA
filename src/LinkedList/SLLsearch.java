public class SLLsearch
{
    private ListNode head;
    public static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data=data;
        }
    }
    public Boolean find(ListNode head,int key){
        if(head==null) //if head ==null no elements are found
            return false;
        ListNode current=head;
        while(current!=null)
        {
        if (current.data==key)
        {
            return true;
        }
        current=current.next;
        }
        return false;  //loop iterate completly search element not found
    }


    public static void main(String[] args)
    {
        SLLsearch sll=new SLLsearch();
        sll.head=new ListNode(10);
        ListNode second=new ListNode(2);
        ListNode third=new ListNode(25);
        ListNode fourth=new ListNode(21);
        ListNode fifth=new ListNode(3);

        sll.head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        ListNode current=sll.head;  //we need to pass head we cant directly pass head
        if(sll.find(current,10))  //condition true pe work karega
        {
            System.out.println("search element is found");
        }
        else
        {
            System.out.println("search element not found");
        }
    }
}
