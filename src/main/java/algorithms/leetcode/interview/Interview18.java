package algorithms.leetcode.interview;

import java.util.Stack;

public class Interview18 {
    public ListNode deleteNode(ListNode head, int val) {


        ListNode pointer = head;
        if(head.val ==val){
            return head.next;
        }

        while(pointer!=null && pointer.val!=val){
            pointer = pointer.next;
            Stack<Integer>  stack = new Stack();

        }
        if(pointer!=null && pointer.val==val){

        }

        return head;
    }


}
 class ListNode {
    int val;
   ListNode next;
    ListNode(int x) { val = x; }
 }