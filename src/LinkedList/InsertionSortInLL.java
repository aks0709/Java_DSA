package LinkedList;

public class InsertionSortInLL
{
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            ListNode dummy=new ListNode(0);
            ListNode curr=head;
            while(curr!=null){
                //jab tak curr null na ho jaye
                ListNode prev=dummy;
                //everytime we place prev right before curr
                while(prev.next!=null&&prev.next.val<=curr.val){
                    prev=prev.next;
                }
                ListNode next=curr.next;  //this next node will hold remaaining original LL
                curr.next=prev.next; //break the link of curr node with original LL
                prev.next=curr;

                curr=next;
            }

            return dummy.next;
        }
    }
}
