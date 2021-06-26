package algorithms.leetcode.string;

import java.util.HashMap;

public class Three {

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "asdfghj";
        String s5 = "dvdf";
        String s6 = "vqblqcb";
        Three three = new Three();
        System.out.println(three.lengthOfLongestSubstring(s1));
        System.out.println(three.lengthOfLongestSubstring(s2));
        System.out.println(three.lengthOfLongestSubstring(s3));
        System.out.println(three.lengthOfLongestSubstring(s4));
        System.out.println(three.lengthOfLongestSubstring(s5));
        System.out.println(three.lengthOfLongestSubstring(s6));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (left <= right && right < arr.length) {
            if (!map.containsKey(arr[right])) {
                map.put(arr[right], right);
                right++;
            } else {
                max = right - left + 1 > max ? right - left : max;
                int oldLeft = left;

                left = map.get(arr[right])+1;
                for(int i=oldLeft;i<left;i++) {
                    map.remove(arr[i]);
                }
                map.put(arr[right],right);
                right++;
            }
        }
        max = max>map.size()?max:map.size();
        return max;
    }
}
