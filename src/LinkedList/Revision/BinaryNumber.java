package LinkedList.Revision;

public class BinaryNumber {
    public int getDecimalValue(ReverseLinkedList.ListNode head) {
        int result = 0;
        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }
        return result;
    }

}
