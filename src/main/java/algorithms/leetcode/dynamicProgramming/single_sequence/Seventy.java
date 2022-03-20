package algorithms.leetcode.dynamicProgramming.single_sequence;

public class Seventy {
    public int climbStairs(int n) {
        if(n ==1) return 1;
        if(n==2) return 2;
        int minus2 = 1;
        int minus1 = 2;
        int res = 0;
        for(int i=3; i<=n; i++) {
            res = minus1+ minus2;
            minus2 = minus1;
            minus1 = res;
        }

        return res;
    }
}
