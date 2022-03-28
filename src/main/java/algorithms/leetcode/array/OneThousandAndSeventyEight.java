package algorithms.leetcode.array;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OneThousandAndSeventyEight {
    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> ans = new ArrayList<>();
        String[] arr = text.split(" ");
        if(arr.length <=2) {
            return new String[0];
        }
        int left = 0;
        int right = 1;
        while (right<arr.length-1) {
            if(first.equals(arr[left]) && second.equals(arr[right])) {
                ans.add(arr[right+1]);
            }
            left++;
            right++;
        }
        String[] result = new String[ans.size()];
        for(int i=0; i<result.length; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}
