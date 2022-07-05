package algorithms.leetcode.linkList;

import algorithms.leetcode.common.ListNode;

import java.util.Arrays;

public class TwentyFirst {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,4};
        int[] arr2 = new int[] {1,3,4};
        ListNode list1 = ListNode.CreateNodeList(arr1);
        ListNode list2 = ListNode.CreateNodeList(arr2);

        TwentyFirst twentyFirst = new TwentyFirst();
        ListNode list = twentyFirst.mergeTwoLists(list1, list2);
        ListNode.printNode(list);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) {
            return null;
        }else if(list1 == null) {
            return list2;
        }else if(list2 == null) {
            return list1;
        }

        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode head = null;
        ListNode p = head;
        while (true) {
            if(p1 == null && p2 == null) {
                return head;
            }else if (p1 == null) {
                p.next = p2;
                break;
            }else if(p2 == null) {
                p.next = p1;
                break;
            }else {
                if(p1.val>=p2.val) {
                    if(head == null) {
                        head = new ListNode(p2.val);
                        p = head;
                        p2 = p2.next;
                    }else {
                        p.next = new ListNode(p2.val);
                        p2 = p2.next;
                        p = p.next;
                    }

                }else {
                    if(head == null) {
                        head = new ListNode(p1.val);
                        p = head;
                        p1 = p1.next;
                    }else {
                        p.next = new ListNode(p1.val);
                        p1 = p1.next;
                        p = p.next;
                    }

                }

            }
        }

        return head;
    }
}
