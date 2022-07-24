package algorithms.leetcode.sliding_window;

import java.util.HashSet;

public class Three {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        int max = 0;
        for(int left =0; left<len; left++) {
            int right = left;
            while (right<len && set.add(s.charAt(right))) {
                max = Math.max(max, right-left+1);
                right++;
            }
            set.clear();
        }

        return max;
    }
}
