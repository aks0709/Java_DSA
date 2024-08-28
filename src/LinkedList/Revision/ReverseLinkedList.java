package LinkedList.Revision;

public class ReverseLinkedList {


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      //3 pointer approach
    public ListNode reverseList2(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        ListNode forw=null;
        while(curr!=null){
            forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        return prev;
    }

    //recursive approach
        public ListNode reverseList(ListNode head) {
            if(head==null || head.next==null)   //either first node is null or only one node   --> already reversed
                return head;

            ListNode newHead=reverseList(head.next);

            //to understand this better to dry run
            head.next.next=head;
            head.next=null;

            return newHead;
        }


//Let linked list is 1-->2-->3
/*Step-by-Step Execution of the reverse Function:
Initial Call: reverse(head) where head is 1.

Since head is not null and head.next is not null, it makes a recursive call to reverse(head.next), passing node 2.
Recursive Call 1: reverse(2)

Again, head is not null and head.next is not null, so it calls reverse(head.next), passing node 3.
Recursive Call 2: reverse(3)

Now, head.next is null (node 3 is the last node), so it returns 3 as the new head of the reversed list.
Backtracking and Pointer Adjustment:
Now, the recursive calls start returning back, and we adjust the pointers:

Returning to Call 1 (reverse(2)):

newHead = 3 (returned from reverse(3)).
head is 2.
Pointer Adjustment:
head.next.next = head; sets 3.next = 2, effectively reversing the link between 2 and 3.
head.next = null; sets 2.next = null, breaking the original link from 2 to 3.
The adjusted list at this point is:
rust
Copy code
3 -> 2 -> null
Returning to Initial Call (reverse(1)):

newHead = 3 (returned from reverse(2)).
head is 1.
Pointer Adjustment:
head.next.next = head; sets 2.next = 1, reversing the link between 1 and 2.
head.next = null; sets 1.next = null, breaking the original link from 1 to 2.
The fully reversed list is now:
*/
}
