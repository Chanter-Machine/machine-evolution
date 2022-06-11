package algorithms.leetcode.dynamicProgramming;

public class NinehundardAndTwentySix {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();

        if(len == 0 || len == 1) {
            return 0;
        }

        int one = 0;
        int zero = 0;
        for(int i = 0; i<len; i++) {
            char ch = s.charAt(i);
            int newZero = zero;
            int newOne = Math.min(zero, one);
            if(ch == '0') {
                newOne++;
            }else {
                newZero++;
            }
            zero = newZero;
            one = newOne;
        }
        return Math.min(zero, one);
    }

}
