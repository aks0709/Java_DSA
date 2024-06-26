package LinkedList;

public class MergeSortLL {
    class Solution {
        public ListNode sortList(ListNode head) {
            ListNode res= MergeSort(head);
            return res;
        }
        public ListNode MergeSort(ListNode head){
            if(head ==null ||head.next ==null ) //base condition
                return head;


            ListNode mid=GetMid(head);
            ListNode nextToMid=mid.next;
            mid.next=null;

            ListNode Lhead=MergeSort(head);
            ListNode Rhead=MergeSort(nextToMid);

            ListNode res= Merge(Lhead,Rhead);
            return res;
        }
        public ListNode Merge(ListNode a,ListNode b){
            ListNode dummy=new ListNode(0);  //to avoid null pointer error
            ListNode tail=dummy;
            while(a!=null&&b!=null){
                if(a.val<=b.val){
                    tail.next=a;
                    a=a.next;
                }
                else {
                    tail.next=b;
                    b=b.next;
                }
                tail=tail.next;   //as tail is used to link linkedlist
            }
            if(a==null)//list a finish first
            {
                tail.next=b;  //attach list b to tail
            }
            else {
                tail.next=a;
            }
            return dummy.next;
        }
        public  ListNode GetMid(ListNode head){
            if(head==null) return null;

            ListNode slowptr=head;
            ListNode fastptr=head;
            while(fastptr.next!=null&&fastptr.next.next!=null){
                fastptr=fastptr.next.next;
                slowptr=slowptr.next;
            }
            return slowptr;
        }
    }
}
