package algorithms.leetcode.sort;

import java.util.*;

public class FivehundardAndThirtyNine {
    public static void main(String[] args) {
        FivehundardAndThirtyNine fivehundardAndThirtyNine = new FivehundardAndThirtyNine();
        String[] arr = new String[] {"00:00","23:59","00:00"};
        ArrayList<String> list = new ArrayList();
//        list.add("00:00");
//        list.add("23:59");
//        list.add("00:00");
        list.add("01:01");
        list.add("02:01");
        list.add("03:00");
        list.add("03:01");

        fivehundardAndThirtyNine.findMinDifference(list);
    }
    public int findMinDifference(List<String> timePoints) {

        PriorityQueue<Integer> treemap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for(String time : timePoints) {
            String[] timeArr = time.split(":");
            int minutes = Integer.parseInt(timeArr[0])*60 + Integer.parseInt(timeArr[1]);
            treemap.offer(minutes);
//            if(minutes == 0) {
//                treemap.offer(1440+minutes);
//            }
        }

        int min = Integer.MAX_VALUE;
        int size = treemap.size();
        int first = treemap.peek();
        for(int i=0; i<size-1; i++) {
            int top = treemap.poll();
            if(!treemap.isEmpty()) {
                int diff = treemap.peek() - top;
                if(min> diff) {
                    min = diff;
                }
            }
        }

        return min;
    }


}
