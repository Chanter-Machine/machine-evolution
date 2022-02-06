package algorithms.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;

public class SeventeenFourtyEight {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,2};
        SeventeenFourtyEight seventeenFourtyEight = new SeventeenFourtyEight();
        seventeenFourtyEight.sumOfUnique(arr);
    }
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0; i<nums.length;i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                sum+= nums[i];
            }else if(map.get(nums[i]) == 1){
                map.put(nums[i], 2);
                sum -= nums[i];
            }
        }
        return sum;
    }
}
