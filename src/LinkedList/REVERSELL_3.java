package LinkedList;

import java.util.List;

/*public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }*/
public class REVERSELL_3
{
    class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode next=null;
        ListNode prev=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }
    public ListNode reverseList2(ListNode head){
        if(head==null||head.next==null) //empty  list or list of one length
            return head;
        ListNode chotaHead=reverseList2(head.next);

        head.next.next=head;
        head.next=null;
        return chotaHead;
    }
    public void reverseList3(ListNode head,ListNode curr,ListNode prev){
        /*
        when we reach end of linked list ,prev is just before curr so make lastnode as head of reversed LL
*/        if(curr!=null)
        {
            head=prev;
            return;
        }

        /*
        check approach one next=curr.next;
        curr.next=prev;
        prev=curr
        curr=next;
        */
        ListNode forward=curr.next;
        reverseList3(head,forward,curr);
        curr.next=prev;
    }

    }
}
