package LinkedList;

public class SwapNodesInPair
{
    class Solution {
        public ListNode swapPairs(ListNode head) {
            int N=len(head);
            ListNode arr[]=new ListNode[N];
            ListNode curr=head;
            int i=0;
            while(curr!=null)
            {
                ListNode temp=curr;
                arr[i++]=temp;
                curr=curr.next;
            }
            for(int index=0;index<N-1;index+=2){
                ListNode temp=arr[index];
                arr[index]=arr[index+1];
                arr[index+1]=temp;
            }
            if(N!=0){
                arr[N-1].next=null;
            }

            ListNode newListNode= N!=0 ? arr[0] : null;
            ListNode res=newListNode;
            for(int index=1;index<N;index++){
                newListNode.next=arr[index];
                newListNode=newListNode.next;
            }
            return res;

        }
        public int len(ListNode head){
            ListNode temp=head;
            int count=0;
            while(temp!=null){
                temp=temp.next;
                count+=1;
            }
            return count;
        }
    }
}
