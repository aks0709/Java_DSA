package LinkedList;

public class ReverseLLinKGrps {
    class Solution {
        public int size(ListNode head){
            if(head==null){
                return 0;
            }
            if(head.next == null){
                return 1;
            }
            int p =0;
            ListNode current = head;
            while(current != null){
                current = current.next;
                p++;
            }
            return p; }
        public ListNode reverseKGroup(ListNode head, int k) {
            //base case
            if(head==null) return null;
            if(head.next==null) return head;

            //this  problem has 3 steps
            //step 1:- reverse k nodes
            ListNode curr=head;
            ListNode next=null;
            ListNode prev=null;
            int count=0;
            while(count< k && curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
                count++;
            }

            //step 2 recursion will handle the rest of the case
            if(next!=null && size(next)>=k){
                head.next=reverseKGroup(next,k);
            }
            else
                head.next=next;

            //step 3 return head of reversed linked list
            return prev;

        }
    }
}
