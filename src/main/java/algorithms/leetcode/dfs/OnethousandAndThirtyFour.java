package algorithms.leetcode.dfs;

import java.util.ArrayList;

public class OnethousandAndThirtyFour {
    public static void main(String[] args) {
        int[][] arr = new int[][] {{1,1},{1,2}};
        OnethousandAndThirtyFour onethousandAndThirtyFour = new OnethousandAndThirtyFour();
        onethousandAndThirtyFour.colorBorder(arr, 0,0, 3);

    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        ArrayList<Integer[]> border = new ArrayList<>();
        dfs(grid, row, col, grid[row][col], visited, border);
        for(Integer[] arr : border) {
            grid[arr[0]][arr[1]] = color;
        }
        return grid;
    }

    public void dfs(int[][] grid, int row, int col, int colorOld, boolean[][] visited, ArrayList<Integer[]> borderArr) {
        if(row<0 || row >= grid.length || col <0 || col >= grid[0].length || visited[row][col] || grid[row][col]!=colorOld) {
            return ;
        }

        visited[row][col] = true;
        if(row == 0 || col ==0 || row == grid.length-1 || col==grid[0].length-1 ||
                grid[row-1][col] != colorOld || grid[row+1][col]!=colorOld || grid[row][col-1]!=colorOld ||
                grid[row][col+1]!=colorOld) {
            Integer[] border = new Integer[]{row, col};
            borderArr.add(border);
        }
        dfs(grid, row-1, col, colorOld, visited, borderArr);
        dfs(grid, row+1, col, colorOld, visited, borderArr);
        dfs(grid, row, col-1, colorOld, visited, borderArr);
        dfs(grid, row, col+1, colorOld, visited, borderArr);
    }
}
