package PP.Day10;

import LinkedList.SLLRevision;

public class LL {
     private ListNode head;
    public static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }
public static void fun(ListNode l){
        if(l==null) return;

    System.out.print(l.data+"-->");
    fun(l.next);
}
    public static ListNode IterativereverseList(ListNode head) {
        ListNode prev=null;
        ListNode forward;
        ListNode curr=head;
        while(curr!=null){
            forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
        }
        return prev;
    }
/*public static ListNode Recursivereverse(ListNode head){
if(head==null||head.next==null) return head;
    ListNode temp=head.next;
    head.next=null;
ListNode res=Recursivereverse(temp);
temp.next=head;
return res;
}*/
    public static void main(String[] args) {
        LL l=new LL();
        l.head=new ListNode(10);
        ListNode sec=new ListNode(5);
        ListNode third=new ListNode(15);
        ListNode fourth=new ListNode(53);
        ListNode fifth=new ListNode(25);
        ListNode sixth=new ListNode(58);
        l.head.next=sec;
        sec.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=null;
        ListNode curr=l.head;
        while(curr!=null){
            System.out.print(curr.data+"-->");
            curr=curr.next;
        }
        System.out.print("null[Iterative Output]");
        System.out.println();
        ListNode temp=l.head;
        fun(temp);
        System.out.print("null[RECURSIVE OUTPUT]");
        System.out.println();
        ListNode temp2=l.head;
        ListNode temp3=IterativereverseList(temp2);
        fun(temp3);
        System.out.print("NULL[Reversed LL]");
        /*System.out.println();
        ListNode temp4=l.head;
        ListNode temp5=Recursivereverse(temp4);
        fun(temp5);
        System.out.print("NULL[Reversed LL BY RECURSION]");*/
    }
}
