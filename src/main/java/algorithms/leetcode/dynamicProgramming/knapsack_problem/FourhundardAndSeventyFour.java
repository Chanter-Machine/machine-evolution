package algorithms.leetcode.dynamicProgramming.knapsack_problem;

public class FourhundardAndSeventyFour {
    public static void main(String[] args) {
        String[] strs = new String[]{"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;
        FourhundardAndSeventyFour fourhundardAndSeventyFour = new FourhundardAndSeventyFour();
        int res = fourhundardAndSeventyFour.findMaxForm(strs, m, n);
        System.out.println(res);
    }

    public int findMaxForm(String[] strs, int m, int n) {

        Integer[][] countAll = countStr(strs);
        int[][][] dp = new int[strs.length+1][m+1][n+1];


        for(int i=1; i<=strs.length; i++) {
            for(int j=0; j<=m; j++) {
                for(int k=0; k<=n; k++) {
                    dp[i][j][k] = dp[i-1][j][k];
                    if(j>=countAll[i-1][0] && k>= countAll[i-1][1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-countAll[i-1][0]][k-countAll[i-1][1]]+1);
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    private Integer[][] countStr(String[] strs) {
        Integer[][] countAll = new Integer[strs.length][2];
        for(int i=0; i<strs.length;i++) {
            Integer[] count = new Integer[]{0,0};
            for(int j=0; j<strs[i].length(); j++) {
                if(strs[i].charAt(j) == '0') {
                    count[0] ++;
                }else {
                    count[1] ++;
                }
            }
            countAll[i] = count;
        }
        return countAll;
    }
}
