package algorithms.leetcode.math;

public class TwentyTwenty {
    public int[] missingRolls(int[] rolls, int mean, int n) {

        int mSum = 0;
        for(int num : rolls) {
            mSum += num;
        }
        int m = rolls.length;
        int nSum = (m+n) * mean - mSum;
        if(nSum <n || nSum> n*6) {
            return new int[0];
        }
        int avg = nSum/n;
        int rest = nSum % n;
        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            res[i] = avg;
            if(rest >0) {
                res[i]++;
                rest--;
            }
        }

        return res;
    }
}
