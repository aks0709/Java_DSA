public class InsertionINsortedList
{
    private ListNode head;
    public static class ListNode {
        private int data;
        private ListNode next=null;
        public ListNode(int data) {
            this.data = data;
        }
    }
    public void display(){
        ListNode current=head;
        while(current!=null){
            System.out.println(current.data+"-->");
            current=current.next;
        }
        System.out.println("null");
    }
    public void InsertNode(int value){
        if(head==null)
            return;
        else {
            ListNode current=head;
            ListNode previous=null;
            ListNode newnode=new ListNode(value);
            while(current!=null&&current.data<newnode.data){
                previous=current;
                current=current.next;
            }
            previous.next=newnode;
            newnode.next=current;

        }
    }

    public void DeleteKeyNode(int key){
            ListNode current=head;
            ListNode previous=null;
            while(current!=null&&current.data!=key){
                previous=current;
                current=current.next;
            }
            if(current==null)
                return;
            previous.next=current.next;
    }

    public static void main(String[] args) {
        InsertionINsortedList sll=new InsertionINsortedList();
        sll.head=new ListNode(1);
        ListNode second=new ListNode(3);
        ListNode third=new ListNode(4);
        ListNode fourth=new ListNode(6);
        ListNode fifth=new ListNode(7);

        sll.head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;

        sll.display();
        sll.InsertNode(5);
        sll.display();
        sll.DeleteKeyNode(6);
        sll.display();
    }
}
