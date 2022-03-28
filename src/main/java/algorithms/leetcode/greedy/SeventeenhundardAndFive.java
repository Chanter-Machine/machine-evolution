package algorithms.leetcode.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SeventeenhundardAndFive {
    public int eatenApples(int[] apples, int[] days) {
        ArrayList<Integer[]> arr = new ArrayList<>();
        for(int i=0; i<apples.length; i++) {
            if(apples[1] == 0) {
                continue;
            }
            arr.add(new Integer[]{1, Math.min(apples[i], days[i])-1});

        }
        PriorityQueue<Integer[]> heap = new PriorityQueue<>(arr.size(), new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[1] - o1[1];
            }
        });
        int sum = 0;
        for(int i=0; i<arr.size(); i++){

        }
        return 0;
    }

    public int eatenApples2(int[] apples, int[] days) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        int sum=0;
        int i=0;
        for(; i<apples.length; i++) {
            while (!heap.isEmpty() && heap.peek()[1]<=i) {
                heap.poll();
            }
            if(apples[i] != 0){
                heap.offer(new int[]{apples[i], i+days[i]});
            }
            if(!heap.isEmpty()) {
                if(--heap.peek()[0] == 0 ){
                    heap.poll();
                }
                sum++;
            }

        }
        while (!heap.isEmpty()) {

            while (!heap.isEmpty() && heap.peek()[1]<=i) {
                heap.poll();
            }
            if(!heap.isEmpty()) {
               int[] arr = heap.poll();
               int curr = Math.min(arr[1] - i, arr[0]);
               sum += curr;
               i+= curr;
            }
        }

        return sum;
    }
}
