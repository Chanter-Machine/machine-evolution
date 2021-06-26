package algorithms.leetcode.heap;

import algorithms.leetcode.common.ListNode;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TweentyThree {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<lists.length;i++) {
            while (lists[i]!=null) {
                queue.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        if(queue.size() == 0) {
            return null;
        }
        ListNode head = new ListNode();
        head.val = queue.poll();
        ListNode pointer = head;
        while (!queue.isEmpty()) {
            ListNode node = new ListNode();
            node.val = queue.poll();
            pointer.next = node;
            pointer = pointer.next;
        }

        return head;
    }


}

class Heap {
    ArrayList<Integer> data = new ArrayList<>();

    //在数组最后面加入一个数字，并对它进行堆排序操作
    public void heapifyUp(int index) {
        if (index==0) {
            return;
        }
        int parent = (index-1)/2;
        if (data.get(index) >= data.get(parent)) {
            return;
        }
        swap(index, parent);
        heapifyUp(parent);
    }

    public void swap(int index, int parentIndex) {
        int temp = data.get(index);
        data.set(index, parentIndex);
        data.set(parentIndex, temp);
    }

    public void push(int newData) {
        data.add(newData);
        heapifyUp(data.size()-1);
    }

    public int pop() {
        swap(0, data.size()-1);
        int min = data.get(data.size()-1);
        data.remove(data.size()-1);
        heapifyDown(0);
        return min;
    }

    public void heapifyDown(int index) {
        int smallest = index;
        for(int c: new int[]{index*2+1, index*2+2}) {
            if(c<data.size() && data.get(c)< data.get(index)){
                smallest = c;
            }
        }
        if(smallest ==  index) {
            return;
        }
        swap(index, smallest);
        heapifyDown(smallest);
    }
}