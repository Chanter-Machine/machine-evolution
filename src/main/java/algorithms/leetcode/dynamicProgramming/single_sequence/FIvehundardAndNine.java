package algorithms.leetcode.dynamicProgramming.single_sequence;

public class FIvehundardAndNine {
    public int fib(int n) {
        if(n ==0) return 0;
        if(n ==1) return 1;
        int minus2 = 0;
        int minus1 = 1;
        int res = 0;
        for(int i=2; i<=n; i++) {
            res = minus1+ minus2;
            minus2 = minus1;
            minus1 = res;
        }

        return res;
    }
}
