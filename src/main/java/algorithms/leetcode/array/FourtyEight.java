package algorithms.leetcode.array;

import algorithms.leetcode.utils.PrintArray;

public class FourtyEight {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {5, 1, 9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };


        FourtyEight fourtyEight = new FourtyEight();
        fourtyEight.rotate(matrix2);
        PrintArray.print2dIntegerArray(matrix2);

    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int k=0;k<len/2;k++) {
            for(int i=k;i<len-1-k;i++) {
                int currentRow = k;
                int currentCol = i;
                int preVal = matrix[currentRow][currentCol];
                for(int j=0;j<4;j++) {
                    int temp = matrix[currentCol][len-1-currentRow];
                    matrix[currentCol][len-1-currentRow] = preVal;
                    int tempRow = currentRow;
                    currentRow = currentCol;
                    currentCol = len - 1 - tempRow;
                    preVal = temp;
//                    PrintArray.print2dIntegerArray(matrix);
                }
//                PrintArray.print2dIntegerArray(matrix);
            }

        }

    }
}
