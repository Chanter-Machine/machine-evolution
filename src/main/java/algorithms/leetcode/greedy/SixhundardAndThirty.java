package algorithms.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SixhundardAndThirty {
    public static void main(String[] args) {

    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[0] - o1[0];
            }
        });
        int sumDuration = 0;
        for(int i=0; i<courses.length; i++) {
           if(sumDuration + courses[i][0] <= courses[i][1]) {
               queue.offer(new Integer[]{courses[i][0], courses[i][1]});
               sumDuration += courses[i][0];
           }else if(!queue.isEmpty() && queue.peek()[0]>courses[i][0]){
               Integer[] course = queue.poll();
               sumDuration = sumDuration - course[0] + courses[i][0];
               queue.offer(new Integer[]{courses[i][0], courses[i][1]});
           }

        }
        return queue.size();
    }
}
