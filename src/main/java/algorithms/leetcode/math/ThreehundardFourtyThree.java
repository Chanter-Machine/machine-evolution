package algorithms.leetcode.math;

public class ThreehundardFourtyThree {
    public static void main(String[] args) {
        ThreehundardFourtyThree threehundardFourtyThree = new ThreehundardFourtyThree();
        System.out.println(threehundardFourtyThree.integerBreak(10));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 0;
        int res = 1;
        for(int i=2;i<=n;i++) {
            dp[i] = 1;
            int temp = 1;
            for(int j=1;j<i;j++) {
                int mulRes1 = (i-j)*j;
                int mulRes2 = dp[i-j]*j;
                temp = mulRes1>=mulRes2? mulRes1: mulRes2;
                dp[i] = temp>dp[i]?temp:dp[i];
            }
        }
        return dp[n];
    }
}
