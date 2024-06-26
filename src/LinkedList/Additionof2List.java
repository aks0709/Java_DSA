public class Additionof2List
{
    private ListNode head;
    public static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data=data;
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

    public static ListNode AddList(ListNode a,ListNode b){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        int carry=0;
        while(a!=null||b!=null){
            int x=(a!=null)?a.data:0;
            int y=(b!=null)?b.data:0;
            int  sum=x+y+carry;
            carry=sum/10;
            tail.next=new ListNode(sum%10);
            tail=tail.next;
            if(a!=null) a=a.next;
            if(b!=null) b=b.next;
        }
        if(carry>0)
            tail.next=new ListNode(carry);
        return dummy.next;
    }
    public static void main(String[] args) {
        Additionof2List sll1=new Additionof2List();
        sll1.InsertLast(5);
        sll1.InsertLast(7);
        sll1.InsertLast(9);

        Additionof2List sll2=new Additionof2List();
        sll2.InsertLast(5);
        sll2.InsertLast(8);

        sll1.display();
        sll2.display();
        Additionof2List resultantList=new Additionof2List();
        resultantList.head=AddList(sll1.head,sll2.head);
        resultantList.display();
    }
}
