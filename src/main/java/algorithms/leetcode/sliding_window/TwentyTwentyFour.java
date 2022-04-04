package algorithms.leetcode.sliding_window;

public class TwentyTwentyFour {

    public static void main(String[] args) {
        TwentyTwentyFour twentyTwentyFour = new TwentyTwentyFour();
        int res = twentyTwentyFour.maxConsecutiveAnswers("TTTT", 2);
        System.out.println(res);
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(flipChar(answerKey, k, 'T'), flipChar(answerKey, k, 'F'));
    }

    public int flipChar(String answerKey, int k, char ch) {
        int len = answerKey.length();
        int ans = 0;
        for(int left=0, right = 0, sum = 0; right<len; right++) {
            if( answerKey.charAt(right) == ch) {
                sum+=1;
            }
            while (sum>k) {
                if(answerKey.charAt(left) == ch) {
                    sum--;
                }
                left++;
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}
