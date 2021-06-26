package algorithms.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FiftyFour {

    public static void main(String[] args) {
        int[][]matrix = new int[][]{
                {1, 2, 3 },
                {4, 5, 6 },
                {7, 8, 9 }
        };

        int[][]matrix2 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };
        FiftyFour fiftyFour = new FiftyFour();
        System.out.println(fiftyFour.spiralOrder(matrix2));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) {
            return new ArrayList<>();
        }
        int cols = matrix[0].length;
        int total = rows*cols;
        LinkedList<Integer> list = new LinkedList<>();
        int i = 0;
        int j = 0;
        int temp = Integer.MAX_VALUE;
        while(total>0) {
            // j++
            for(;;) {
                list.add(matrix[i][j]);
                matrix[i][j] = temp;
                total--;

                if(j+1 == cols || matrix[i][j+1] == temp){
                    if(i+1 <= rows-1 && matrix[i+1][j] != temp){
                        i++;
                    }
                    break;
                }
                j++;
            }
            if(total==0) {
                break;
            }
            // i++
            for(;;) {
                list.add(matrix[i][j]);
                matrix[i][j] = temp;
                total--;

                if(i+1 == rows || matrix[i+1][j] == temp){
                    if(j-1 >= 0 && matrix[i][j-1] != temp){
                        j--;
                    }
                    break;
                }
                i++;
            }
            if(total==0) {
                break;
            }
            // j--
            for(;;) {
                list.add(matrix[i][j]);
                matrix[i][j] = temp;
                total--;

                if(j-1<0 || matrix[i][j-1] == temp){
                    if(i-1 >= 0 && matrix[i-1][j] != temp){
                        i--;
                    }
                    break;
                }
                j--;
            }
            if(total==0) {
                break;
            }
            // i--
            for(;;) {
                list.add(matrix[i][j]);
                matrix[i][j] = temp;
                total--;

                if(i-1<0 || matrix[i-1][j] == temp){
                    if(j+1 <= cols-1 && matrix[i][j+1] != temp){
                        j++;
                    }
                    break;
                }
                i--;
            }
            if(total==0) {
                break;
            }
        }

        return list;
    }
}
