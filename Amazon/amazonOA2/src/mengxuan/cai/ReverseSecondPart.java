package mengxuan.cai;

/**
 * Created by feideng on 11/22/16.
 */
public class ReverseSecondPart {
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode leftPart = slow;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            leftPart = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightPart = null;
        while(slow != null) {
            ListNode tmp = slow.next;
            slow.next = rightPart;
            rightPart = slow;
            slow = tmp;
        }
        leftPart.next = rightPart;
        return head;
    }
}
