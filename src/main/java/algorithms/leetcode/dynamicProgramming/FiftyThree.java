package algorithms.leetcode.dynamicProgramming;

public class FiftyThree {
    public static void main(String[] args) {
        FiftyThree fiftyThree = new FiftyThree();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums1 = new int[]{-2,-1,3};
        int[] nums2 = new int[]{-1,-2};
        System.out.println(fiftyThree.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }

        int[]sum = new int[nums.length];
        int pre = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            sum[i] = pre+nums[i]>nums[i]?pre+nums[i]:nums[i];
            pre = sum[i];
            if (sum[i]>max) {
                max = sum[i];
            }
        }

        return max;

    }
}
