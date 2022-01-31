package algorithms.leetcode.dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SevenTeenSixtyFive {
    public int[][] highestPeak(int[][] isWater) {
        int row = isWater.length;
        int col = isWater[0].length;
        int[][] result = new int[isWater.length][isWater[0].length];
        for(int i=0; i<row;i++) {
            Arrays.fill(result[i], -1);
        }
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i=0;i< row; i++) {
            for(int j=0; j<col; j++) {
                if(isWater[i][j]==1) {
                    queue.offerLast(new int[]{i, j});
                    result[i][j] = 0;
                }
            }
        }
        int[][] dircs = new int[][]{{1, 0}, {-1,0},{0, -1},{0, 1}};

        while (!queue.isEmpty()) {
            int[] point = queue.pollFirst();
            for (int[] dirc : dircs) {
                int x = point[0]+dirc[0];
                int y = point[1] + dirc[1];
                if(x <0 || x>=row || y<0 || y>=col ||result[x][y] != -1) {
                    continue;
                }
                result[x][y] = result[point[0]][point[1]] + 1;
                queue.addLast(new int[]{x, y});
            }
        }


        return result;
    }


}
