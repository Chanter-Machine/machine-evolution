package algorithms.leetcode.dynamicProgramming;

public class Five {

    public static void main(String[] args) {
        String s = "babad";
        String s2 = "cbbd";
        String s3 = "a";
        String s4 = "ac";
    }

    public String longestPalindrome(String s) {
        if(s.length() == 0) {
            return s;
        }else if(s.length() == 1) {
            return s;
        }

        char[] arr = s.toCharArray();

        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0, j=i+1;i<s.length();i++) {
            dp[i][i] = true;
            if(j<s.length() && arr[i]==arr[j]){
                dp[i][j] = true;
                dp[j][i] = true;
            }
        }

        //not finished
        return "";
    }
}
