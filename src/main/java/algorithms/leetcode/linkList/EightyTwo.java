package algorithms.leetcode.linkList;

import algorithms.leetcode.common.ListNode;

public class EightyTwo {
    public static void main(String[] args) {
//        ListNode head = ListNode.createTest(new int[] {1,1,1,3,4,4,5});
        ListNode head = ListNode.createTest(new int[] {1,1});
//        ListNode head = ListNode.createTest(new int[] {1,2,2,3,3,5});
        EightyTwo eightyTwo = new EightyTwo();
        head = eightyTwo.deleteDuplicates(head);
        ListNode.printNode(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode pre = null;
        ListNode node = head;

        while (node != null) {
            node = iter(node);
            if(pre == null) {
                head = node;
            }else {
                pre.next = node;
            }
            pre = node;
            if(node != null) {
                node = node.next;
            }
        }

        return head;
    }

    public ListNode iter(ListNode head) {
        if(head == null) {
            return head;
        }
        int jumpCount = 0;
        while (head.next != null && head.next.val == head.val) {
            head = head.next;
            jumpCount ++;
        }
        if(jumpCount != 0) {

            head = head.next;
            return iter(head);
        }else {
            return head;
        }
    }
}
