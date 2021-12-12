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



    public String longestPalindrome2(String s) {
        if(s.length() == 0 || s.length() == 1 ) {
            return s;
        }
        int maxLen = 1;
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[arr.length][arr.length];
        int begin = 0;

        for(int L= 2; L<= s.length(); L++) {
            for(int i=0;i<s.length(); i++) {
                int j= L +i -1;
                if (j>= s.length()) {
                    break;
                }
                if(arr[i] != arr[j]) {
                    dp[i][j] = false;
                }else {
                    if( j-i < 3) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1] && (arr[i]==arr[j]);
                    }
                }

                if(dp[i][j] && j-1+1>maxLen) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

}
