package algorithms.leetcode.dfs;

public class FourhundardAndNineteen {
    public static void main(String[] args) {

    }

    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if (dfs(board, i, j) == 1) {
                    count ++;
                }
            }
        }
        return count;
    }

    public int dfs(char[][] board, int row, int col) {
        if(row <0 || col <0 || row==board.length|| col==board[0].length || board[row][col] == '.') {
            return 0;
        }
        board[row][col] = '.';
        dfs(board, row+1, col);
        dfs(board, row, col+1);
        dfs(board, row-1, col);
        dfs(board, row, col-1);
        return 1;
    }
}
