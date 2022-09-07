package algorithms.leetcode.dynamicProgramming.knapsack_problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class OnehundardAndThirtyNine {
    public static void main(String[] args) {
        OnehundardAndThirtyNine onehundardAndThirtyNine = new OnehundardAndThirtyNine();
        onehundardAndThirtyNine.wordBreak("leetcode", Arrays.asList("leet", "code"));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);

        for(int i=1; i<=len; i++) {
            for(int j=0; j<i; j++) {
                if( dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[len];
    }
}
