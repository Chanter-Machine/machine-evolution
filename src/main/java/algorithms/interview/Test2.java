package algorithms.interview;

import java.util.Random;

public class Test2 {

    public static void main(String[] args) {
        final  int  SIze = 20000;
        int [][] matrix = new int[SIze][SIze];
        Random random = new Random();

        long start = System.currentTimeMillis();

        for(int j=0;j<SIze;j++){
            for(int i=0;i<SIze;i++){
                matrix[i][j] = random.nextInt();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
