package algorithms.leetcode.array;

import java.util.Arrays;

public class FourhundardAndSixtyTwo {
    public static void main(String[] args) {
        FourhundardAndSixtyTwo fourhundardAndSixtyTwo = new FourhundardAndSixtyTwo();
        int res = fourhundardAndSixtyTwo.minMoves2_2(new int[]{1, 10, 2, 9});
        System.out.println(res);
    }
    public int minMoves2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        Arrays.sort(nums);
        int mid = 0;
        if(nums.length % 2 == 0) {
            mid = (nums[(nums.length-1)/2] + nums[(nums.length-1)/2 + 1])/2;
        }else {
            mid = nums[(nums.length-1)/2];
        }
        int count = 0;
        for(Integer num : nums) {
            count += Math.abs(mid - num);
        }
        return count;
    }

    public int minMoves2_2(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0;
        int midNum = nums[len/2];
        for(int i=0; i<len; i++) {
            sum += Math.abs(nums[i] - midNum);
        }

        return sum;
    }
}
