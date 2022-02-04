package algorithms.leetcode.map;

import java.util.HashMap;

public class SeventeenTwentyFive {
    public int countGoodRectangles(int[][] rectangles) {
        int count = 0;
        int maxLen = 0;
        for(int i=0; i<rectangles.length; i++) {
            int len = Math.min(rectangles[i][0], rectangles[i][1]);
            if(maxLen<len) {
                count = 1;
                maxLen = len;
            }else if(maxLen == len) {
                count++;
            }
        }
        return count;
    }
}
