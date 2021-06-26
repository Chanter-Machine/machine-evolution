package algorithms.leetcode.array;

import java.util.HashMap;

public class ThreeHundardEightSeven {
    public static void main(String[] args) {
        String s = "leetcode";
        String s1 = "loveleetcode";
        ThreeHundardEightSeven threeHundardEightSeven = new ThreeHundardEightSeven();
        System.out.println(threeHundardEightSeven.firstUniqChar(s1));
    }

    public int firstUniqChar(String s) {
        char[] input = s.toCharArray();
        HashMap<Character, Boolean> map = new HashMap();
        for(int i=0;i<input.length;i++) {
            if(map.keySet().contains(input[i])) {
                map.put(input[i], true);
            }else {
                map.put(input[i],false);
            }
        }
        for(int i=0;i<input.length;i++) {
            if(!map.get(input[i])) {
                return i;
            }
        }
        return -1;
    }
}
