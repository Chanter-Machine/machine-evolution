package algorithms.leetcode.array;

import algorithms.leetcode.utils.PrintArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FiftySix {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,3  },
                {2,6  },
                {8,10 },
                {15,18}
        };
        FiftySix fiftySix = new FiftySix();
        PrintArray.print2dIntegerArray(fiftySix.merge(intervals));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length ==1) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        ArrayList<int[]> resutls = new ArrayList<>();

        resutls.add(intervals[0]);
        for(int i=1;i<intervals.length;i++) {
            int[]currentArr = intervals[i];
            int[] preResult = resutls.get(resutls.size()-1);
            if(currentArr[0]>preResult[1]) {
                resutls.add(currentArr);
            }else {
                if(currentArr[1]>preResult[1]) {
                    preResult[1]= currentArr[1];
                }
            }
        }
        int[][] arrResults = new int[resutls.size()][2];
        for(int i=0;i<resutls.size();i++) {
            arrResults[i] = resutls.get(i);
        }

        return arrResults;
    }
}
