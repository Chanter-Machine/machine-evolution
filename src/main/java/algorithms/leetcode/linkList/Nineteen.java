package algorithms.leetcode.linkList;

import algorithms.leetcode.common.ListNode;

public class Nineteen {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        ListNode node = ListNode.createTest(arr);

        Nineteen nineteen = new Nineteen();
        ListNode.printNode(nineteen.removeNthFromEnd(node, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode pointer1 = head;
        ListNode pointer2 = head;

        for(int i=0;i<n; i++) {
            pointer1 = pointer1.next;
        }
        if (pointer1 == null) {
            head = head.next;
            return head;
        }

        while (pointer1.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        pointer2.next = pointer2.next.next;
        return head;
    }
}
