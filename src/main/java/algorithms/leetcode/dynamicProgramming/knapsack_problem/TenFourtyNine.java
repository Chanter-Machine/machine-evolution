package algorithms.leetcode.dynamicProgramming.knapsack_problem;

public class TenFourtyNine {
    public int lastStoneWeightII(int[] stones) {

        int sum = 0;
        for(int stone : stones) {
            sum += stone;
        }
        int half  = sum/2;
        int[] dp = new int[half +1];
        for(int i=0; i< stones.length; i++) {
            int[] tmpDp = new int[half+1];
            for (int j = 1; j < dp.length; j++) {
                tmpDp[j] = dp[j];
                if(j>=stones[i]) {
                    tmpDp[j] = Math.max(tmpDp[j], dp[j-stones[i]]+stones[i]);
                }
            }
            dp = tmpDp;
        }

        return Math.abs(sum - 2*dp[half]);
    }
}
