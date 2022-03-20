package algorithms.leetcode.dynamicProgramming.game_theory;

public class FourhundardAndEightySix {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        dfs(nums, 0, nums.length-1, dp);
        return dp[0][nums.length - 1] >= 0;
    }

    private int dfs(int[] arr, int left, int right, int[][] dp) {
        if(left>right) {
            return 0;
        }
        dp[left][right] = Math.max(arr[left]-dfs(arr, left+1, right, dp), arr[right]-dfs(arr, left, right-1, dp));

        return dp[left][right];
    }
}
