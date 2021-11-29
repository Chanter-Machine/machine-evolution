package algorithms.leetcode.math;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SevenhundardAndEightySix {
    public static void main(String[] args) {
        SevenhundardAndEightySix sevenhundardAndEightySix = new SevenhundardAndEightySix();
        int[] arr = new int[] {1,2,3,5};
        int[] res = sevenhundardAndEightySix.kthSmallestPrimeFraction(arr, 3);
        System.out.println(res);
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]*o1[1] - o1[0]*o2[1];
            }
        });

        for(int i=0; i<arr.length-1; i++) {
           for(int j=i+1; j<arr.length;j++) {
               if(heap.size()<k) {
                   heap.offer(new int[]{arr[i], arr[j]});
               }else {
                   if(heap.peek()[0] * arr[j] > heap.peek()[1]* arr[i]) {
                       heap.remove();
                       int[] tmp = new int[]{arr[i], arr[j]};
                       heap.offer(tmp);
                   }
               }
           }
        }

        return heap.poll();
    }
}
