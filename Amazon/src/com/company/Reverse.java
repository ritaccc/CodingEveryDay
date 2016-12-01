package com.company;

import java.util.List;

/**
 * Created by feideng on 11/15/16.
 */
public class Reverse {
    public ListNode reverseSec(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode suc = slow;
        //find the mid point and the listnode before mid point
        while(fast != null && fast.next != null) {
            suc = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null;
        while(slow != null) {
            ListNode tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
        }
        suc.next = pre;
        return head;
    }
}