package algorithms.leetcode.string;

import algorithms.leetcode.utils.PrintArray;

public class Four {

    public static void main(String[] args) {
        String s = "babad";
        String s2 = "cbbd";
        String s3 = "aacabdkacaa";
        String s4 = "aaaa";
        String s5 = "bb";
        Four four = new Four();
        System.out.println(four.longestPalindrome(s5));
    }

    public String longestPalindrome(String s) {
        if(s.length() == 0) {
            return "";
        }else if(s.length() == 1) {
            return s;
        }else if(s.length() == 2) {
            if(s.charAt(0) == s.charAt(1)) {
                return s;
            }else
                return s.charAt(0)+"";
        }
        char[] input = s.toCharArray();
        boolean[][]dp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length()-1;i++) {
            dp[i][i] = true;
            if(input[i] == input[i+1]) {
                dp[i][i+1] = true;
            }else{
                dp[i][i+1] = false;
            }
        }
        dp[s.length()-1][s.length()-1] = true;
        int longest = 1;
        String result = input[0]+"";
        for(int j=2;j<dp.length;j++) {
            for(int i=0,k=j;k<dp.length;i++,k++) {
                dp[i][k] = dp[i+1][k-1] && (input[i]==input[k]);
            }
        }
        dp[0][dp.length-1] = dp[1][dp.length-2] && (input[0]==input[dp.length-1]);
        for(int i=0;i<dp.length;i++) {
            for(int j = i+1;j<dp.length;j++) {
                if(dp[i][j] && j-i+1>longest) {
                    longest = j-i+1;
                    result = s.substring(i, j+1);
                }
            }
        }
        PrintArray.print2dBooleanArray(dp);
        return result;
    }
}
