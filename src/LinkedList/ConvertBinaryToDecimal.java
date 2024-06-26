package LinkedList;
/*Given head which is a reference node to a singly-linked list.
The value of each node in the linked list is either 0 or 1.
The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

The most significant bit is at the head of the linked list.

 */
public class ConvertBinaryToDecimal
{
    class Solution {
        public int getDecimalValue(ListNode head) {
            int N=len(head);
            int res=0;
            int n=N-1;
            ListNode curr=head;
            while(curr!=null){
                if(curr.val==1){
                    int a=(int)Math.pow(2,n);
                    res=res+a;
                }
                n=n-1;
                curr=curr.next;
            }

            return res;
        }
        public int len(ListNode head){
            ListNode curr=head;
            int count=0;
            while(curr!=null){
                count=count+1;
                curr=curr.next;
            }

            return count;
        }
    }

}
