package algorithms.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TwohundardAndFifteen {
    public static void main(String[] args) {
        int[] arr = new int[] {3,2,1,5,6,4};
        TwohundardAndFifteen twohundardAndFifteen = new TwohundardAndFifteen();
        int res = twohundardAndFifteen.findKthLargest(arr,2);
        System.out.println(res);
    }
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for (Integer num : nums) {
            if(heap.size()<k) {
                heap.add(num);
                continue;
            }
            if(heap.peek() < num) {
                heap.poll();
                heap.add(num);
            }
        }


        return heap.peek();
    }
}
