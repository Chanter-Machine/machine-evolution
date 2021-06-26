package algorithms.leetcode.linkList;

import algorithms.leetcode.common.ListNode;

import java.util.*;

public class Two {

    public static void main(String[] args) {
        int [] arr = new int[] {2,4,9};
        ListNode node1 = ListNode.createTest(arr);
        int [] arr2 = new int[] {5,6,4,9};
        ListNode node2 = ListNode.createTest(arr2);


        Two two = new Two();
        ListNode node = two.addTwoNumbers(node1, node2);

        ListNode.printNode(node);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> queue1 = new LinkedList<>();
        while(l1 != null) {
            queue1.add(l1.val);
            l1 = l1.next;
        }
        int l1Size = queue1.size();

        Queue<Integer> queue2 = new LinkedList<>();
        while(l2 != null) {
            queue2.add(l2.val);
            l2 = l2.next;
        }
        int l2Size = queue2.size();
        ArrayList<Integer> resultList = new ArrayList<>();
        int extra = 0;
        if(l1Size>=l2Size) {
            extra = addCommonLen(queue1, queue2, resultList, extra);
            addExtraLen(queue1, resultList, extra);
        }else {
            extra = addCommonLen(queue2, queue1, resultList, extra);
            addExtraLen(queue2, resultList, extra);
        }


        ListNode l3Head = null;
        ListNode pointer = null;

        for(int i=0;i<resultList.size();i++) {
            ListNode node  = new ListNode();
            node.val = resultList.get(i);
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

    public static int addCommonLen(Queue<Integer> stack1, Queue<Integer>stack2, ArrayList<Integer> resultQueue, int extra) {
        while (!stack2.isEmpty()) {
            int num1 = stack1.poll();
            int num2 = stack2.poll();
            int tempRes = num1 + num2 + extra;

            if (tempRes>=10) {
                resultQueue.add(tempRes-10);
                extra = 1;
            }else {
                resultQueue.add(tempRes);
                extra = 0;
            }
        }
        return extra;
    }

    public static void addExtraLen(Queue<Integer> stack, ArrayList<Integer> resultQueue, int extra) {
        while (!stack.isEmpty()) {
            int num1 = stack.poll();
            int tempRes = num1 + extra;
            if (tempRes>=10) {
                resultQueue.add(tempRes-10);
                extra = 1;
            }else {
                resultQueue.add(tempRes);
                extra = 0;
            }
        }
        if (extra == 1) {
            resultQueue.add(1);
        }
    }

}
