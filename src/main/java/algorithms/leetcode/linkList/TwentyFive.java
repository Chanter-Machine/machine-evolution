package algorithms.leetcode.linkList;

import algorithms.leetcode.common.ListNode;

public class TwentyFive {
    public static void main(String[] args) {
        ListNode n1  = new ListNode(1);
        ListNode n2  = new ListNode(2);
        ListNode n3  = new ListNode(3);
        ListNode n4  = new ListNode(4);
        ListNode n5  = new ListNode(5);
        ListNode n6  = new ListNode(6);
        ListNode n7  = new ListNode(7);
        ListNode n8  = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        TwentyFive twentyFive = new TwentyFive();
        twentyFive.reverseKGroup(n1, 3);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }

        return reverse(head, k, 0, n/k);
    }

    public ListNode reverse(ListNode node, int k, int reverseCount, int totalReverse) {
        if(node == null) {
            return null;
        }
        if (reverseCount == totalReverse) {
            return node;
        }
        ListNode pre = null;
        ListNode next = null;
        ListNode tail = node;
        ListNode head = null;
        int count = 0;
        while (node != null) {
            count ++;
            next = node.next;
            node.next = pre;
            pre = node;
            if (count == k) {
                head = node;
                tail.next = reverse(next, k, reverseCount +1, totalReverse);
                return head;
            }
            node = next;
        }

        return null;
    }
}
