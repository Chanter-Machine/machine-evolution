package algorithms.leetcode.two_pointer;

import java.util.Arrays;

public class Sixteen {
    public static void main(String[] args) {
        int[] arr = new int[] {-1,2,1,-4};
        Sixteen sixteen = new Sixteen();
        sixteen.threeSumClosest(arr, 1);
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;
        int min = nums[0] + nums[1] + nums[N-1];
        for(int i=0; i<=N-3; i++) {
            int left = i+1;
            int right = N-1;
            while (left<right) {
                int sum = nums[i]+nums[left]+nums[right];
                if(Math.abs(sum-target) < Math.abs(min - target)) {
                    min = sum;
                }
                if( sum >= target) {
                    right--;
                }else {
                    left++;
                }
            }
        }
        return min;
    }
}
