package algorithms.leetcode.array;

public class FifteenEightTwo {
    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[] rowArr = new int[rows];
        int[] colArr = new int[cols];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                rowArr[i] += mat[i][j];
                colArr[j] += mat[i][j];
            }
        }
        int res = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(mat[i][j] == 1 && rowArr[i]==1 && colArr[j] ==1) {
                    res++;
                }
            }
        }
        return res;
    }
}
