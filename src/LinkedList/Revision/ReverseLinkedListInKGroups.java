package LinkedList.Revision;

public class ReverseLinkedListInKGroups {
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {

        //pre-requisite please do reverse LL using recursion
        //if number of nodes is less than k then simply return head
    /*
    we solve this question recursively
    //base case
    1)  reverse  first k nodes
    2) recursion will handle rest of the cases
    3)return node of reversed linked list
    */
        public static int getSize(ListNode head){
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
            return p;
        }
        public ListNode reverseKGroup(ListNode head, int k) {
            //already reversed
            if(head==null || head.next==null)
                return head;

            if(getSize(head)<k) return head;

            //1)reverse first k nodes
            ListNode curr=head;
            ListNode prev=null;
            ListNode forw=null;
            int count=0;
            while(curr!=null && count<k){
                forw=curr.next;
                curr.next=prev;
                prev=curr;
                curr=forw;
                count++;
            }

            // Step 2: Recursively reverse the next k-group if possible
            if (forw != null && getSize(forw) >= k) {
                head.next = reverseKGroup(forw, k);
            } else {
                head.next = forw; // Connect the remaining nodes if less than k
            }


            //3) return head of reversed LL
            return prev;
        }
    }
}
