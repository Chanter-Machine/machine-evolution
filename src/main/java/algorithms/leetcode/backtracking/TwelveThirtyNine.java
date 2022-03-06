package algorithms.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class TwelveThirtyNine {
    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        str.add("cha");
        str.add("r");
        str.add("act");
        str.add("ers");
        TwelveThirtyNine twelveThirtyNine = new TwelveThirtyNine();
        int res = twelveThirtyNine.maxLength(str);
        System.out.println(res);
    }

    public int maxLength(List<String> arr) {
        ans = 0;
        List<Integer> newArr = new ArrayList<>();
        for(String str : arr) {
            int mask =0;
            for(int i=0;i<str.length(); i++) {
                int ch = str.charAt(i) - 'a';
                if(((mask >> ch) &1) != 0) {
                    mask = 0;
                    break;
                }
                mask |= 1<<ch;
            }
            if(mask >0) {
                newArr.add(mask);
            }
        }

        this.backtracking(newArr, 0, 0);
        return ans;
    }

    int ans = 0;
    public void backtracking(List<Integer> masks, int index, int mask){

        if(index == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        int curMask = masks.get(index);
        if( (curMask & mask) == 0) {
            backtracking(masks, index+1, mask | curMask);
        }
        backtracking(masks, index+1, mask);
    }
}
