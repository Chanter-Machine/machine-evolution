package algorithms.leetcode.dynamicProgramming.game_theory;

public class EighthundardAndSeventySeven {
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,4,5};
        EighthundardAndSeventySeven eighthundardAndSeventySeven = new EighthundardAndSeventySeven();
        eighthundardAndSeventySeven.stoneGame(arr);
    }

    public boolean stoneGame(int[] piles) {
        if(piles.length == 1) {
            return true;
        }
        Integer[][]dp = new Integer[piles.length][piles.length];
        return dfs(piles, 0, piles.length - 1, dp) > 0;
    }

    public Integer dfs(int[] arr, int left, int right, Integer[][] dp) {
        if(left>right) {
            return 0;
        }
        if(dp[left][right] != null) {
            return dp[left][right];
        }
        dp[left][right] = Math.max(arr[left]- dfs(arr,left+1, right, dp), arr[right]-dfs(arr, left, right-1, dp));

        return dp[left][right];
    }

//    public boolean stoneGame2(int[] piles) {
//        if(piles.length == 1) {
//            return true;
//        }
//        int[] dp = new int[piles.length];
//        for(int i=0; i< piles.length; i++) {
//            dp[i] = piles.length;
//        }
//        return dfs(piles, 0, piles.length - 1, dp) > 0;
//    }

}
