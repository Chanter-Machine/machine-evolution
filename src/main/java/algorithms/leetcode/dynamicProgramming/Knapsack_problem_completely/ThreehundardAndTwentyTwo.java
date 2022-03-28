package algorithms.leetcode.dynamicProgramming.Knapsack_problem_completely;

import java.util.Arrays;

public class ThreehundardAndTwentyTwo {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=0; i<coins.length; i++) {
            int[] tmpDP = new int[amount+1];
            for (int j = 1; j <= amount; j++) {
                tmpDP[j] = dp[j];
                if(j >= coins[i]) {
                    tmpDP[j] = Math.min(dp[j], tmpDP[j-coins[i]]+1);
                }
            }
            dp = tmpDP;
        }

        return dp[amount]== amount+1? -1:dp[amount];
    }
}
