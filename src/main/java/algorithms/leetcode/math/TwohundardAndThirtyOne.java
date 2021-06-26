package algorithms.leetcode.math;

import algorithms.leetcode.linkList.Two;

public class TwohundardAndThirtyOne {

    public static void main(String[] args) {
        TwohundardAndThirtyOne twohundardAndThirtyOne = new TwohundardAndThirtyOne();
        System.out.println(twohundardAndThirtyOne.isPowerOfTwo(1));
    }

    public boolean isPowerOfTwo(int n) {
        if (n<0) {
            return false;
        }

        while (n != 0) {
            if(n == 1) {
                return true;
            }
           if(n %2 == 1) {
               return false;
           }
           n = n/2;
        }
        return false;
    }
}
