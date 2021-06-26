package algorithms.leetcode.linkList;

import algorithms.leetcode.common.ListNode;

public class TwohundardAndSix {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        ListNode head = ListNode.createTest(arr);
        TwohundardAndSix twohundardAndSix = new TwohundardAndSix();
        ListNode newHead = twohundardAndSix.reverseList(head);
        ListNode.printNode(newHead);
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
