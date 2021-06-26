package algorithms.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourHandardFortyTwo {
    public static void main(String[] args) {
        FourHandardFortyTwo fourHandardFortyTwo = new FourHandardFortyTwo();

        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(fourHandardFortyTwo.findDuplicates(arr));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List <Integer> list = new ArrayList<>();
        int len = nums.length;
        for(int i=0; i<len; i++) {
            while( nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }

        for(int i=0; i<len; i++) {
            if(nums[i]!=i+1 && nums[i] == nums[nums[i]-1]) {
                list.add(nums[i]);
            }
        }

        return list;
    }

    public static void swap(int[]nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
