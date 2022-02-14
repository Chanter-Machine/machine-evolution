package algorithms.leetcode.binary_search;

public class FivehundardAndFourty {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left<right) {
            int mid = left + (right - left)/2;
            if(judge(nums, mid)) {
                left = mid+1;
            }else {
                right = mid;
            }
        }

        return nums[left];
    }

    private boolean judge(int[] nums, int index) {
        int size = nums.length;
        if(index %2 ==0) {
            if(index +1<size && nums[index] == nums[index+1]) {
                return true;
            }else {
                return false;
            }
        }else {
            if(index-1 >=0 && nums[index] == nums[index-1] ) {
                return true;
            }else {
                return false;
            }
        }
    }
}
