package algorithms.leetcode.binary_search;

import algorithms.leetcode.math.Fifty;

import java.util.Arrays;

public class FivehundardAndThirtyTwo {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 3, 3, 4, 5, 6};
        int k = 3;
        FivehundardAndThirtyTwo fivehundardAndThirtyTwo = new FivehundardAndThirtyTwo();
        int res = fivehundardAndThirtyTwo.binarySearchFindLeft(arr, 0, arr.length - 1, k);
        System.out.println(res);

        res = fivehundardAndThirtyTwo.binarySearchFindRight(arr, 0, arr.length - 1, k);
        System.out.println(res);

        arr = new int[]{1,1,3,5,4};
        fivehundardAndThirtyTwo.findPairs(arr, 0);

    }

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int prev = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == prev) {
                continue;
            }

            if (binarySearchFindLeft(nums, i+1, len - 1, nums[i] + k) != -1) {
                res++;
            }


            prev = nums[i];
        }

        return res;
    }

    private int binarySearchFindLeft(int[] arr, int left, int right, int k) {
        if(left > right || left>= arr.length) {
            return -1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (arr[left] == k) {
            return left;
        }
        return -1;
    }

    private int binarySearchFindRight(int[] arr, int left, int right, int k) {
        while (left < right) {
            int mid = left + (right - left+1) / 2;
            if (arr[mid] > k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (arr[left] == k) {
            return left;
        }
        return -1;
    }
}