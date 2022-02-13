package algorithms.leetcode.stack.monotonic;

import algorithms.leetcode.common.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class TenNineteen {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode node = head;
        while ( node != null) {
            arr.add(node.val);
            node = node.next;
        }

        int[] res= new int[arr.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.size()-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek()<= arr.get(i)) {
                stack.pop();
            }
            res[i] = stack.isEmpty()?0:stack.peek();
            stack.push(arr.get(i));
        }

        return res;
    }
}
