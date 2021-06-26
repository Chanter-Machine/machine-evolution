package algorithms.offer.array;

import java.util.ArrayList;

public class task29 {
    public static void main(String[] args) {

    }
    static Character[] dir = {'r', 'b', 'l', 't'};
    public int[] spiralOrder(int[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;

        int total = width*height;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;
        int j= 0;
        int dirPointer = 0;

        while(count<total){
            switch(dirPointer) {
                case 'r':
                
                    break;
                case 'b':
                    break;

                case 'l':
                    break;
                case 't':
                    break;
                default:
                    break;
            }
        }

        return null;
    }
}
