package algorithms.leetcode.linkList;

import algorithms.leetcode.common.ListNode;
import algorithms.leetcode.math.TwohundardAndThirtyOne;

import javax.rmi.CORBA.Util;

public class ThohundardAndThree {
    public static void main(String[] args) {
        int[] arr = new int[] {7,7};
//        int[] arr = new int[] {1,2,6,3,4,5,6};
        ListNode node = ListNode.CreateNodeList(arr);
        ThohundardAndThree  ThohundardAndThree = new ThohundardAndThree();
        ThohundardAndThree.removeElements(node, 7);
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode node = head;
        while (node != null && node.next != null ) {
            if(node.next.val == val) {
                node.next = node.next.next;
                continue;
            }
            node = node.next;

        }
        return head;
    }
}
