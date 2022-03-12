package algorithms.leetcode.dynamicProgramming.knapsack_problem;

import java.util.Arrays;

public class FourhundardAndNinetyFour {
    public static void main(String[] args) {


    }
    public int findTargetSumWays(int[] nums, int target) {

        int len = nums.length;
        int sum = 0;
        for(int i=0; i<len; i++) {
            sum += nums[i];
        }
        if( sum - target<0 || (sum-target)%2 !=0) {
            return 0;
        }
        int neg = (sum - target) /2;
        int[] dp = new int[neg+1];
        dp[0] = 1;
        for(int i=0; i<len; i++) {
            int[] tmpDP = new int[neg+1];
            for(int j=0; j<=neg; j++) {
                tmpDP[j] = dp[j];
                if(j-nums[i] >=0) {
                    tmpDP[j] += dp[j-nums[i]];
                }
            }
            dp = tmpDP;
        }

        return dp[neg];
    }
}
