package algorithms.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class NinehundardAndNightySeven {
    public static void main(String[] args) {

    }

    public int findJudge(int n, int[][] trust) {
        if( n==1 && trust.length == 0) {
            return 1;
        }
        HashMap<Integer, Integer> counterMap = new HashMap<>(n);
        HashMap<Integer, Integer> trustMap = new HashMap<>(n);

        for(int i=0; i<trust.length; i++) {
            int count = counterMap.getOrDefault(trust[i][1], 0);
            counterMap.put(trust[i][1], count+1);
            trustMap.put(trust[i][0], trust[i][1]);
        }
        for(Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            if(entry.getValue() == n-1) {
                if(trustMap.getOrDefault( entry.getKey(),0 )== 0) {
                    return entry.getKey();
                }
            }
        }
        return -1;
    }
}
