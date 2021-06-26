package algorithms.leetcode.dynamicProgramming;

import algorithms.leetcode.utils.PrintArray;

public class OneThousandAndFour {

    public static void main(String[] args) {
        OneThousandAndFour oneThousandAndFour = new OneThousandAndFour();
        int[] A = new int[]{0,1,0,1,0,0,1};
        int[] A1 = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};

        int result = oneThousandAndFour.longestOnes(A1, 3);
        System.out.println(result);
    }

//    超时
    public int longestOnes(int[] A, int K) {
        if(A.length == 0) {
            return 0;
        }
        int initCount = 0;
        int[] stat = new int[A.length];
        for(int i=0;i<A.length;i++) {
            stat[i] = A[i] == 0?++initCount:initCount;
        }
        /**
         *   0 1 0 1 0 0 1
         *   1 1 2 2 3 4
         */
        int tempLen = 0;
        int numOfZero = 0;
        for(int i=0;i<A.length;i++) {
            for(int j=A.length-1;j>=i;j--) {
                if(j-i+1<tempLen){
                    continue;
                }
                if(stat[j]>stat[i]) {
                    if(A[i] == 0) {
                        numOfZero = stat[j] - stat[i] +1;
                    }else {
                        numOfZero = stat[j] - stat[i];
                    }
                }else {
                    if(A[i] == 0) {
                        numOfZero = 1;
                    }else {
                        numOfZero = 0;
                    }
                }

                if(j-i+1 >= tempLen && numOfZero<=K) {
                    tempLen = j-i+1;
                }
            }
        }
        return tempLen;
    }

    public int longestOnes2(int[] A, int K) {
        if(A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;

        return 0;
    }
}
