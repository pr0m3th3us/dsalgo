package leetcode.allproblems;

import common.InputReader;
import common.LinkedListUtils;
import common.ListNode;

public class _019_RemoveNthNodeFromLL {

    public static void main(String[] args) {
        ListNode head = InputReader.readIntList();
        LinkedListUtils.printList(new _019_RemoveNthNodeFromLL().removeNthFromEnd(head, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fwd = dummy;
        ListNode bhd = dummy;
        for(int i = 0; i <= n; i++) {
            fwd = fwd.next;
        }
        while (fwd != null) {
            fwd = fwd.next;
            bhd = bhd.next;
        }
        if (bhd != null) bhd.next = bhd.next.next;
        return dummy.next;
    }
}
