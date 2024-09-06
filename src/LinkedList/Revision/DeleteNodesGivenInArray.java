package LinkedList.Revision;

public class DeleteNodesGivenInArray {
    /*
    class Solution {
        public ListNode modifiedList(int[] nums, ListNode head) {
            HashSet<Integer> set=new HashSet<Integer>();
            for(int num : nums)
                set.add(num);

            ListNode dummyHead=new ListNode(-1);  //head of new linked list
            ListNode actualHead=dummyHead;  //always keep track of head ,this is what we return
            while(head!=null){
                if(!set.contains(head.val)){
                    dummyHead.next=new ListNode(head.val);
                    dummyHead=dummyHead.next;
                }
                head=head.next;
            }
            return actualHead.next;
        }
    }
    */
}
