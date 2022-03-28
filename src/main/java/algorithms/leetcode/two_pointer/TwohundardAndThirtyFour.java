package algorithms.leetcode.two_pointer;

import algorithms.leetcode.common.ListNode;

public class TwohundardAndThirtyFour {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        TwohundardAndThirtyFour twohundardAndThirtyFour = new TwohundardAndThirtyFour();
        ListNode right = null;
//        ListNode head = twohundardAndThirtyFour.reverseListNode(node1, 2, right);
        System.out.println("hehe");
        twohundardAndThirtyFour.isPalindrome(node1);
    }
    ListNode right;
    public boolean isPalindrome(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        if(count == 1) {
            return true;
        }
//        ListNode right = null;
        node = head;
        node = reverseListNode(node, count/2);
        if(count%2 ==1) {
            this.right = right.next;
        }
        for(int i=0; i< count/2; i++) {
            if(node.val != right.val) {
                return false;
            }
            node = node.next;
            right = right.next;
        }
        return true;
    }

    private ListNode reverseListNode(ListNode node, int n){
        ListNode tail = null;
        ListNode prev = null;
        ListNode next = null;
        int count = 1;
        while (node != null && count<=n) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            count++;
        }
        this.right = node;
        return prev;
    }
}
