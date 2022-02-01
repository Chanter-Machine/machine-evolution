package algorithms.leetcode.two_pointer;

import java.util.Arrays;

public class NineteenNightySix {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            return o1[0]==o2[0]?(o1[1]-o2[1]):(o2[0]-o1[0]);
        });

        int maxDefense = 0;
        int count = 0;
        for(int i=0; i<properties.length; i++) {
            if(properties[i][1]<properties[maxDefense][1]) {
                count++;
            }else {
                maxDefense = i;
            }
        }

        return count;
    }

}
