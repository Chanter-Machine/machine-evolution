package algorithms.leetcode.BFS;

import algorithms.leetcode.utils.PrintArray;

public class TwohundardEightySix {
    public static void main(String[] args) {
        int INF = 2147483647;
        int[][] rooms = new int[][]{
                {INF, -1, 0 ,INF},
                {INF,INF,INF, -1},
                {INF,INF,INF, -1},
                {0  ,-1 ,INF,INF}};
        int[][] rooms2 = new int[][]{
                {INF},
                };
        int[][] rooms3 = new int[][]{
                {2147483647,0,2147483647,2147483647,0,2147483647,-1,2147483647},
        };
        TwohundardEightySix.wallsAndGates(rooms3);
        PrintArray.print2dIntegerArray(rooms3);
    }

    public static void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        if(rows == 0 ) {
            return;
        }
        int cols = rooms[0].length;
        if(cols == 0 ) {
            return;
        }
        if(cols == 1 && rows==1) {
            return;
        }
        int inf = 2147483647;

        int updateInf = 0;
        do{
            updateInf = 0;
            for(int i=0;i<rows;i++) {
                for(int j=0;j<cols;j++) {
                    int min = inf;

                    if(rooms[i][j] == 0 || rooms[i][j] == -1) {
                        continue;
                    }
                    if(i-1>=0 && rooms[i-1][j] != -1 && rooms[i-1][j]!=inf){
                        min = Math.min(min, rooms[i-1][j]);
                    }
                    if(i+1<=rows-1 && rooms[i+1][j] != -1 && rooms[i+1][j]!=inf) {
                        min = Math.min(min, rooms[i+1][j]);
                    }
                    if(j-1>=0 && rooms[i][j-1] != -1&& rooms[i][j-1] != inf){
                        min = Math.min(min, rooms[i][j-1]);
                    }
                    if(j+1<=cols-1 && rooms[i][j+1] != -1 && rooms[i][j+1] != inf) {
                        min = Math.min(min, rooms[i][j+1]);
                    }
                    if(min!=inf) {
                        if(min+1<rooms[i][j]){
                            updateInf++;
                        }
                        rooms[i][j] = min +1;
                    }

                }
            }
        }while (updateInf>0);

    }
}
