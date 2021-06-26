package algorithms.leetcode.string;

import java.util.HashSet;

public class Task3 {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> recordSet = new HashSet();
        if (s.length() == 0) {
            return 0;
        }
        if(s.length() == 1 ) {
            return 1;
        }
        int right = -1;
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(i!=0) {
                recordSet.remove(s.charAt(i));
            }
            while(right+1<=s.length() && !recordSet.contains(s.charAt(right+1))) {
                recordSet.add(s.charAt(right+1));
                right++;
            }
        }
        return -1;
    }
}
