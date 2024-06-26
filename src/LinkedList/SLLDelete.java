public class SLLDelete
{
    private ListNode head;
    public static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data=data;
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

    public void delete(int position){
        ListNode node=head;
        if(position==1){
            head=head.next;
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
            previous.next=current.next;

        }
    }

    public static void main(String[] args) {
        SLLDelete sll=new SLLDelete();
        sll.insert(1,61);
        sll.insert(2,56);
        sll.insert(3,75);
        sll.insert(4,58);
        sll.insert(5,43);
        sll.delete(1);
        sll.delete(1);
        sll.display();
    }
}
