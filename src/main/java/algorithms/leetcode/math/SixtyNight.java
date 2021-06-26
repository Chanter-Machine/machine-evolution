package algorithms.leetcode.math;

public class SixtyNight {
    public static int mySqrt(int x) {
//        int result = calc(2, x/2, x);
//        System.out.println(result);
//        return result; if(x ==0){
//                return 0;
//            }else if(x==1){
//                return 1;
//            }else{
//
//        }

        long result = calc(0, x/4+1, x);
        System.out.println(result);
        return (int)result;

    }

    public static long calc(long left, long right, int target){
        while(left<=right){
//            int mid = left + (right-left)/2;
            long mid = (left+right)/2;

            long square = (mid * mid);

            long nextSquare = (mid+1)*(mid+1);

            if(square == target || (square<target && nextSquare>target)){
                return mid;
            }else if(square<target) {
                left = mid +1;
            }else if(square>target){
                right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        mySqrt(4);
//        2147395600
//        int result = mySqrt2(8);
//        System.out.println(result);
        StrictMath.sqrt(8);

    }

    public static int mySqrt2(int x) {
        long low = 0;
        long height = (x >>> 2) + 1;
        long lx = (long) x;
        while (low <= height) {
            long mind = (low + height) >>> 1;
            long square = mind * mind;
            if (square == lx) {
                return (int) mind;
            } else if (square < lx) {
                low = mind + 1;
            } else {
                height = mind - 1;
            }
        }
        return (int)height;
    }

}
