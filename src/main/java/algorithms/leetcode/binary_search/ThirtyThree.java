package algorithms.leetcode.binary_search;

public class ThirtyThree {
    public static void main(String[] args) {
        int[] nums = new int[] {4,5,6,7,0,1,2};
        ThirtyThree thirtyThree = new ThirtyThree();
        thirtyThree.search(nums, 0);
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if(len == 1) {
            return nums[0]==target?0:-1;
        }
        int left = 0;
        int right = len-1;
        while (left <= right) {
            int mid = left + (right-left) /2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[0] > nums[mid]) {
                if(target>nums[mid] && target<= nums[len-1]) {
                    left = mid + 1;
                }else {
                    right = mid -1;
                }
            }else {
                if(target>=nums[0] && target<nums[mid]) {
                    right = mid -1;
                }else {
                    left = mid +1;
                }
            }
        }
        return  -1;
    }

}
