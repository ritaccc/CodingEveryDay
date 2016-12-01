package com.company;

/**
 * Created by feideng on 11/16/16.
 */
import java.util.*;
public class CycleLinkedList {
    public ListNode detectCyle(ListNode head, int val) {
        if(head == null) {
            ListNode newHead = new ListNode(val);
            newHead.next = newHead;
            return newHead;
        }

        ListNode cur = head;

        do{
            if(cur.val <= val && cur.next.val >= val) {
                break;
            }
            if(cur.val > cur.next.val && (val < cur.next.val || val > cur.val)){
                break;
            }
            cur = cur.next;
        } while(cur != head) ;
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        return newNode;
    }
}
