package algorithms.leetcode.string;

import java.util.HashMap;

public class EightHundardAndFiftyNine {
    public static void main(String[] args) {

    }

    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }

        if(s.length() == 0) {
            return true;
        }

        char[] charS = s.toCharArray();
        char[] charGoal  = goal.toCharArray();
        if(s.equals(goal)) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(Character c : charS) {
                int num = map.getOrDefault(c, 0);
                num ++;
                if(num>=2) {
                    return true;
                }
                map.put(c, num);
            }
            return false;
        }
        int index = -1;
        int count = 0;
        for(int i=0;i<charGoal.length;i++) {
            if (charS[i] == charGoal[i]) {
                continue;
            }
            count++;
            if(index == -1) {
                index = i;
            }else {

                if (charGoal[i] == charS[index] && charGoal[index] == charS[i]) {
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(count !=2) {
            return false;
        }

        return true;
    }
}
