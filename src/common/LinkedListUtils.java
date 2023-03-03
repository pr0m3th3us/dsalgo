package common;

public class LinkedListUtils {
    private LinkedListUtils() {}

    public static ListNode parseAsIntList(String[] splits) {
        if (splits.length == 0) return null;
        ListNode head = new ListNode(Integer.parseInt(splits[0]));
        ListNode node = head;
        for (int i = 1; i < splits.length; i++) {
            node.next = new ListNode(Integer.parseInt(splits[i]));
            node = node.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode node = head;
        StringBuilder sb = new StringBuilder("[");
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(",");
            }
            node = node.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

}
