package algorithms.leetcode.sort;

import java.util.*;

public class FivehundardAndSix {
    public static void main(String[] args) {
        int[] score = new int[] {5,4,3,2,1};
        FivehundardAndSix fivehundardAndSix = new FivehundardAndSix();
        String[] result = fivehundardAndSix.findRelativeRanks(score);
        System.out.println(result);
    }

    public String[] findRelativeRanks(int[] score) {
        Integer[] newArr = new Integer[score.length];
        for (int i=0; i< newArr.length; i++) {
            newArr[i] = score[i];
        }

        Arrays.sort(newArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        String[] result = new String[newArr.length];
        HashMap<Integer, String> mapping = new HashMap<>();
        for(int i=0; i< newArr.length; i++) {
            if(i==0) {
                mapping.put(newArr[0], "Gold Medal");
            } else if(i == 1) {
                mapping.put(newArr[1], "Silver Medal");
            } else if (i== 2) {
                mapping.put(newArr[2], "Bronze Medal");
            }else {
                mapping.put(newArr[i], (i+1)+"");
            }
        }
        for(int i=0; i<newArr.length; i++) {
            result[i] = mapping.get(score[i]);
        }

        return result;
    }

}
