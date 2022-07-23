package algorithms.leetcode.linkList;

import algorithms.leetcode.common.ListNode;

public class TwentyFour {

    public static void main(String[] args) {
        TwentyFour twentyFour = new TwentyFour();
        ListNode head = ListNode.CreateNodeList(new int[] {1,2,3,4});
        ListNode res = twentyFour.swapPairs(head);

        ListNode.printNode(res);
    }

    public ListNode swapPairs(ListNode head) {
        return revere(head, 2);
    }

    public ListNode revere(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        ListNode node = head;
        ListNode prev = null;
        ListNode tail = head;
        ListNode next = null;

        int cnt = 0;
        while (node != null) {
            if(cnt == k) {
                break;
            }
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            cnt++;
        }
        tail.next = revere(node, k);
        return prev;
    }
}