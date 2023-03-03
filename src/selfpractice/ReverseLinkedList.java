package selfpractice;

import common.InputReader;
import common.LinkedListUtils;
import common.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode reverse = new ReverseLinkedList().reverse(InputReader.readIntList(" "));
        LinkedListUtils.printList(reverse);
        // a -> b -> c -> d -> e -> (null)
    }

    ListNode reverse(ListNode head) {
        return swap(head); //swap(a)
    }

    private ListNode swap(ListNode head) { //d
        // last node or only one node
        if(head.next == null) return head;

        ListNode newHeadNode = swap(head.next);

        // change references for middle chain
        head.next.next = head;
        head.next = null;

        // send back new head node in every recursion
        return newHeadNode;
    }
}
