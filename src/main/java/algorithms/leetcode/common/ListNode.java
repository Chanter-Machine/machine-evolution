package algorithms.leetcode.common;

import java.util.LinkedList;
import java.util.Queue;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createTest(int[] arr) {
        ListNode l3Head = null;
        ListNode pointer = null;
        for(int i=0;i< arr.length;i++) {
            ListNode node  = new ListNode();
            node.val = arr[i];
            if(l3Head == null) {
                l3Head = node;
                pointer = node;
            }else{
                pointer.next = node;
                pointer = pointer.next;
            }
        }
        return l3Head;
    }

    public static ListNode CreateNodeList(int[] arr) {
        ListNode head = null;
        ListNode pointer = null;
        for(int i=0; i<arr.length;i++) {
            ListNode node = new ListNode(arr[i]);
            if(head == null) {
                head = node;
                pointer = node;
                continue;
            }
            pointer.next = node;
            pointer = pointer.next;
        }
        return head;
    }

    public static void printNode(ListNode node){
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}