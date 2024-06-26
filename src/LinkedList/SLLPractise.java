
public class SLLPractise
{
    private ListNode head;




    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;

        }

    }

    public static void main(String[] args) {
        SLLPractise sll=new SLLPractise();
        sll.head=new ListNode(10);
        ListNode second=new ListNode(2);
        ListNode third =new ListNode(23);
        ListNode fourth=new ListNode(4);

        sll.head.next=second;
        second.next=third;
        third.next=fourth;

    }
}

