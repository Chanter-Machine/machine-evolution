package algorithms.leetcode.dynamicProgramming.game_theory;

public class TenTwentyFive {

    public boolean divisorGame(int n) {

        return false;
    }
    public boolean calc(int n) {
        boolean[]dp;
        if(n>3) {
            dp = new boolean[n+1];
        }else {
            dp = new boolean[4];
        }
        dp[1] = false;
        dp[2] = true;
        dp[3] = false;
        for(int j=4; j<=n; j++) {
            for(int i=1; i<=j/2; i++){
                if(j % i == 0) {
                    dp[j] |= !dp[j-i];
                }
                if (dp[j]){
                    break;
                }
            }
        }


        return dp[n];
    }
}
