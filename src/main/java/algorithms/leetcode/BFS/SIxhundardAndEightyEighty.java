package algorithms.leetcode.BFS;

import java.util.LinkedList;

public class SIxhundardAndEightyEighty {

    int[][] dircs = new int[][] {{1,2},{1,-2},{-1,2},{-1,-2},{-2,1},{-2,-1},{2,-1},{2,1}};
    public double knightProbability(int n, int k, int row, int column) {

        LinkedList<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{row, column});
        int round = k;
        while (k>0) {
            LinkedList<Integer[]> tmpQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                Integer[] pos = queue.pollFirst();
                for(int i=0; i<8; i++) {
                    int newX = pos[0] + dircs[i][0];
                    int newY = pos[1] + dircs[i][1];
                    if(newX >=0 && newX < n && newY>= 0&& newY<n) {
                        tmpQueue.add(new Integer[]{newX, newY});
                    }
                }
            }
            queue = tmpQueue;
            k--;
        }

        double res = queue.size();
        for(int i=0; i<round; i++) {
            res = res/8;
        }
        return res;
    }
}
