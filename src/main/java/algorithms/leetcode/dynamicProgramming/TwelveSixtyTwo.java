package algorithms.leetcode.dynamicProgramming;

public class TwelveSixtyTwo {
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,5,1,8};
        TwelveSixtyTwo twelveSixtyTwo = new TwelveSixtyTwo();
        twelveSixtyTwo.maxSumDivThree(arr);
    }
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length+1][3];
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for(int i=1; i<=nums.length;i++) {
            int mod = nums[i-1]%3;
            if(mod == 0) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][0] + nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][1] + nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][2] + nums[i-1]);
            }else if(mod ==1) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] + nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + nums[i-1]);
            }else if (mod == 2) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2] + nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][0] + nums[i-1]);
            }
        }

        return  dp[nums.length][0];

    }
}
