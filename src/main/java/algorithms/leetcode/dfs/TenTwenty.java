package algorithms.leetcode.dfs;

public class TenTwenty {


    public int numEnclaves(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid[0].length; i++) {
            dfs(grid, 0, i, visited);
            dfs(grid, grid.length-1, i, visited);
        }
        for(int i=0; i<grid.length; i++) {
            dfs(grid, i, 0, visited);
            dfs(grid, i, grid[0].length-1 , visited);
        }
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] !=0 && !visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    final int[][]dirc = new int[][] {{1,0}, {-1,0}, {0, -1}, {0,1}};
    public void dfs(int[][] arr, int x, int y, boolean[][] visited) {
        if(x<0 || y<0|| x>=arr.length|| y>=arr[0].length|| visited[x][y] || arr[x][y] == 0) {
            return;
        }

        visited[x][y] = true;
        for(int[] newDirc : dirc) {
            int newX = x + newDirc[0];
            int newY = y + newDirc[1];
            dfs(arr, newX, newY, visited);
        }

    }
}
