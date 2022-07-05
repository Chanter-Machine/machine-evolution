package algorithms.leetcode.linkList;

import algorithms.leetcode.common.ListNode;

import java.util.List;

public class OnehundardAndFortyEight {
    public static void main(String[] args) {
        int [] arr = new int[] {4,2,1,3};
        ListNode nodeList = ListNode.createTest(arr);
        OnehundardAndFortyEight onehundardAndFortyEight = new OnehundardAndFortyEight();
        ListNode res = onehundardAndFortyEight.sortList(nodeList);
        ListNode.printNode(res);
    }

    public ListNode sortList(ListNode head) {

        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if(head == null) {
            return head;
        }else if(head.next == null) {
            return head;
        }else if(head.next.next == null) {
            ListNode list2 = head.next;
            ListNode list1 = head;
            list1.next = null;
            return mergeTwoLists(list1, list2);
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if(fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode l2 = slow.next;
        slow.next = null;
        ListNode sortedL1 = mergeSort(head);
        ListNode sortedL2 = mergeSort(l2);
        return mergeTwoLists(sortedL1, sortedL2);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
