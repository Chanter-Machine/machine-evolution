package algorithms.leetcode.string;

public class Five {

    public String longestPalindrome(String s) {
        return "";
    }

    //中心扩展
    public void centerExpand(String s){
        int len = s.length();
        char [] arr = s.toCharArray();
        int mid = len/2;
        int left, right;
        int maxLen = 0;
        String maxStr;

        for(int i=0;i<len-1;i++){
            left = right = arr[i];
            int tempLen = 0;
            int result1=0,result2;

                left = i;
                right = i+1;
                result1 = judge(arr, left, right);

                left=i-1;
                right = i+1;
                result2 = judge(arr, left, right);

            int tempResult = result1>=result2?result1:result2;

        }


    }

    public int judge(char[] arr, int left, int right){
        int count = 0;
        while(left>=0 && right<arr.length && arr[left] == arr[right]){
            count++;
        }
        return  count;
    }

    //dynamic planning
    public void DP(char[] arr){
        int len = arr.length;
        boolean [][] status = new boolean[len][len];

        //初始化对角线
        for(int i=0;i<len;i++){
            status[i][i] = true;
        }

        //初始化长度为二的区间
        for(int i=0;i<len-1;i++){
            status[i][i+1] = arr[i]==arr[i+1]?true:false;
        }

        //初始化长度为三的区间
        for(int i=0;i<len-2;i++){
            status[i][i+2] = arr[i]==arr[i+2]?true:false;
        }

        //判断区间[i,j]是否为回文只需要判断[i+1, j-1]是否为回文&& arr[i]==[j]?
        for(int i=0;i<len;i++){
            for(int j=i+3;j<len;j++){
                if(status[i+1][j-1]==true && arr[i]==arr[j]){
                    //是回文
                }
            }
        }
    }

    public String longestPalindrome2(String s) {
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
        // PrintArray.print2dBooleanArray(dp);
        return result;
    }

}
