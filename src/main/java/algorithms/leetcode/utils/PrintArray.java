package algorithms.leetcode.utils;

public class PrintArray {

    public static void print2dIntegerArray(int[][] matrix) {
       for(int i=0; i<matrix.length;i++){
           for(int j=0;j<matrix[0].length;j++) {
               System.out.print(matrix[i][j]+" ");
           }
           System.out.println();
       }
       System.out.println();
    }

    public static void print2dBooleanArray(boolean[][] matrix) {
        for(int i=0; i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
