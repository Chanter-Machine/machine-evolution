package algorithms.leetcode.prefix_sum;

public class NinehundardAndTwnetySix {
    public static void main(String[] args) {
        String str1 = new String("00110");
        String str2 = new String("010110");
        String str3 = new String("00011000");
        NinehundardAndTwnetySix ninehundardAndTwnetySix = new NinehundardAndTwnetySix();

        System.out.println(ninehundardAndTwnetySix.minFlipsMonoIncr(str1));
        System.out.println(ninehundardAndTwnetySix.minFlipsMonoIncr(str2));
        System.out.println(ninehundardAndTwnetySix.minFlipsMonoIncr(str3));
        System.out.println(ninehundardAndTwnetySix.minFlipsMonoIncr("0101100011"));
        System.out.println(ninehundardAndTwnetySix.minFlipsMonoIncr("10011111110010111011"));
    }

    public int minFlipsMonoIncr(String s) {
        int len = s.length();

        if(len == 0 || len == 1) {
            return 0;
        }

        int[] sumOne = new int[len+1];
        int[] sumZero = new int[len+1];
        for(int i=0;i<len; i++) {
            if(s.charAt(i) == '0') {
                sumZero[i+1] = sumZero[i]+1;
                sumOne[i+1] = sumOne[i];
            }else {
                sumZero[i+1] = sumZero[i];
                sumOne[i+1] = sumOne[i]+1;
            }
        }

        int minOP = Integer.MAX_VALUE;
        for(int i=1; i<=len;i++) {
            int op1 = sumZero[len] - sumZero[i];
            int op2 = sumOne[i-1];

            minOP = Math.min(minOP, op1 + op2);
        }
        return minOP;
    }
}
