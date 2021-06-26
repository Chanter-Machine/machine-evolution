package algorithms.leetcode.array;

import java.util.HashMap;

public class One {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        for(int i=0;i<nums.length;i++) {
            int rest = target - nums[i];
            Integer anotherKey = map.get(rest);
            if(anotherKey != null) {
                return new int[]{anotherKey, i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }

}
