package algorithms.leetcode.dfs;

public class TwentyNineteen {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,6,0},
                {5,8,7},
                {0,9,0}};
        TwentyNineteen twentyNineteen = new TwentyNineteen();
        int res = twentyNineteen.getMaximumGold(grid);
        System.out.println(res);
    }

    public int getMaximumGold(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        boolean[][] path = new boolean[row][col];
        for(int i=0; i<row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 0) {
                    continue;
                }
                int tmpRes = findMax(grid, i, j, path);
                if(tmpRes> max) {
                    max = tmpRes;
                }
            }
        }

        return max;
    }
    int[][] dirc = new int[][]{{-1, 0},{1,0},{0, 1},{0,-1}};
    private int findMax(int[][] grid, int x, int y, boolean[][] path) {

        if(x<0 || x>= grid.length || y<0|| y>=grid[0].length|| grid[x][y]==0|| path[x][y]) {
            return 0;
        }
        path[x][y] = true;
        int val = grid[x][y];
        int max = val;
        for(int i=0; i<4; i++) {
           int newX = x+dirc[i][0];
           int newY = y+dirc[i][1];
           int addVal = findMax(grid, newX, newY, path);
           val += addVal;
           if(max<val) {
               max = val;
           }
           val -= addVal;
        }
        path[x][y] = false;
        return max;
    }
}
