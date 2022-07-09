package algorithms.leetcode.dynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;

public class EighthundardAndSeventyThree {
    public static void main(String[] args) {
        int[] arr = new int[] {1,3,7,11,12,14,18};
        EighthundardAndSeventyThree eighthundardAndSeventyThree = new EighthundardAndSeventyThree();
        int res = eighthundardAndSeventyThree.lenLongestFibSubseq(arr);
        System.out.println(res);
    }

    HashSet<Integer> set;
    HashMap<String, Integer> map;
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        set = new HashSet<>();
        map = new HashMap<>();
        for(int i=0; i<len ; i++) {
            set.add(arr[i]);
        }
        int maxLen = 0;
        for(int i=0; i<len-3; i++) {
            for(int j=i+1; j<len-2; j++) {
                maxLen = Math.max(maxLen, findNext(arr[i], arr[j]));
            }
        }

        return maxLen==0?0:maxLen+2;
    }

    private int findNext(int ele1, int ele2 ){
        if(set.contains(ele1+ ele2)) {
            int res = map.getOrDefault(ele1+"_"+ele2, 0);
            if( res != 0) {
                return res;
            }
            res = 1 + findNext(ele2, ele1+ele2);
            map.put(ele1+"_"+ele2, res);
            return res;
        }
        return 0;
    }
}
