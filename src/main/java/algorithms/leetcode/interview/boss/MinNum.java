package algorithms.leetcode.interview.boss;

import java.util.PriorityQueue;

public class MinNum {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,2,4,6,8,10,12,452,1,6,325};
        print(arr);
    }

    public static void print(int[] array) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0; i < 10; i++){
            maxHeap.offer(array[i]);
        }
        for(int i = 10; i < array.length; i++){
            if(maxHeap.peek() > array[i]){
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }

        for(int i = 0; i < 10; i++){
            System.out.println(maxHeap.poll());
        }
    }
}
