package algorithms.leetcode.binary_search;

import algorithms.leetcode.sliding_window.Thirty;

public class ThirtyFour {
    public static void main(String[] args) {
        ThirtyFour thirtyFour = new ThirtyFour();
        thirtyFour.searchRange(new int[] {5,7,7,8,8,10}, 8);
    }
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[] {-1, -1};
        if(len ==0) {
            return res;
        }

        res[0] = findLeftBunndary(nums, 0, len-1, target);
        res[1] = findRightBunndary(nums, 0, len-1, target);
        return res;
    }

    private int findLeftBunndary(int []nums, int left, int right, int target) {

        while (left < right) {
            int mid = left + (right - left ) /2;
            if( nums[mid] <target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        if(nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findRightBunndary(int []nums, int left, int right, int target) {

        while (left < right) {
            int mid = left + (right - left +1) /2;
            if( nums[mid] >target) {
                right = mid -1;
            }else {
                left = mid;
            }
        }

        if(nums[left] == target) {
            return left;
        }
        return -1;
    }
}
