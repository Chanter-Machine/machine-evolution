package algorithms.leetcode.map;

import java.util.HashMap;

public class OnehundardAndSixtySeven {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for(int i=0; i<numbers.length; i++) {
            int index = map.getOrDefault(target - numbers[i], -1);
            if (index != -1) {
                return new int[] {i+1, index+1};
            }
        }
        return null;
    }
}
