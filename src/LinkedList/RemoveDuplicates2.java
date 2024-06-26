package LinkedList;
import java.util.*;
public class RemoveDuplicates2 {
    public static void main(String[] args) {
        class Solution {
            public ListNode deleteDuplicates(ListNode head) {
                if(head==null||head.next==null){ return head;}
                HashMap<Integer,Integer> map=new HashMap<>();
                ListNode node=new ListNode(-1);
                ListNode prev=node;
                ListNode curr=head;
                while(curr!=null){
                    if(map.containsKey(curr.val)){
                        map.put(curr.val,map.get(curr.val)+1);
                    }else{
                        map.put(curr.val,0);
                    }
                    curr=curr.next;
                }
//main logic line
                curr=head;
                while(curr!=null){
                    if(map.get(curr.val)==0){
                        prev.next=curr;
                        prev=curr;
                    }
                    curr=curr.next;}
                if(prev.next!=null){
                    prev.next=null;

                }
                return node.next;
            }
        }
    }
}
