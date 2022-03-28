package algorithms.leetcode.string;

public class FiftyEight {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length() -1;
        while (s.charAt(i) == ' ') {
            i--;
        }
        for(; i>=0; i--) {
            if(s.charAt(i) != ' ') {
                count++;
                continue;
            }
            break;
        }

        return count;
    }
}
