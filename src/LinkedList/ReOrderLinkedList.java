package LinkedList;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class ReOrderLinkedList {
    class Solution {
        public void reorderList(ListNode head) {
            ListNode slowptr=head;
            ListNode fastptr=head;
            while(fastptr!=null&&fastptr.next!=null){
                fastptr=fastptr.next.next;
                slowptr=slowptr.next;
            }
            ListNode newNode=reverseList(slowptr.next);
            slowptr.next=null;
            ListNode p=head;
            ListNode q=newNode;
            while(p!=null&&q!=null){
                ListNode temp=p.next;
                p.next=q;
                ListNode temp2=q.next;
                q.next=temp;
                p=temp;
                q=temp2;
            }
        }
        public ListNode reverseList(ListNode node){
            ListNode prev = null;
            ListNode curr = node;
            ListNode next = null;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }

            return prev;
        }
    }
}
