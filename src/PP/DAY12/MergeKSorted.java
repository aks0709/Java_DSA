package PP.DAY12;

public class MergeKSorted {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //T.C O(N^2)
    //brute force
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;

        if(list2==null)
            return list1;

        if(list1.val<list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }
        else{
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode HEAD=null;
        for(ListNode h: lists){
            HEAD=mergeTwoLists(HEAD,h);
        }
        return HEAD;
    }

    //optimised


    public ListNode MergeSort(ListNode[] lists,int low,int high){
        if(low>high) return null;

        if(low==high)
            return lists[low];

        int mid=(low+high)/2;
        ListNode left=MergeSort(lists,low,mid);
        ListNode right=MergeSort(lists,mid+1,high);

        return mergeTwoLists(left,right);
    }
    public ListNode mergeKLists2(ListNode[] lists) {

        ListNode res=MergeSort(lists,0,lists.length-1);
        return res;
    }

}
