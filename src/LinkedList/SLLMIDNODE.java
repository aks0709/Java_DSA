public class SLLMIDNODE
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
        ListNode current=head;
        while(current!=null){
            System.out.println(current.data+"-->");
            current=current.next;
        }
        System.out.println("null");
    }
   public ListNode nnodefromend(int n,ListNode head)
   {
       if(head==null)
           return null;
       else {
           ListNode mainptr=head;
           ListNode refptr=head;
           int count=0;
           while(count<n)
           {
               refptr=refptr.next;
               count++;
           }
           while(refptr!=null){
               refptr=refptr.next;
               mainptr=mainptr.next;
           }
           return mainptr;
       }

   }
    public ListNode midNode(ListNode head)
    {
        if(head==null){
            return null;
        }
        else{
            ListNode slowptr=head;
            ListNode fastptr=head;
            while(fastptr!=null&&fastptr.next!=null){
                slowptr=slowptr.next;
                fastptr=fastptr.next.next;
            }
            return slowptr;
        }

    }

    public static void main(String[] args) {
        SLLMIDNODE sll=new SLLMIDNODE();
        ListNode head=new ListNode(12);
        ListNode second=new ListNode(72);
        ListNode third=new ListNode(42);
        ListNode fourth=new ListNode(32);
        ListNode fifth=new ListNode(22);

        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;

        ListNode midNode=sll.midNode(head);
        System.out.println(midNode.data);

        System.out.println("n th node :-");
        ListNode Nnodefromend=sll.nnodefromend(2,head);
        System.out.println(Nnodefromend.data);
    }
}
