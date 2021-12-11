package algorithms.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class OnethousandAndFive {
    public static void main(String[] args) {
        int[] arr1 = new int[] {4,3,2};
        int[] arr2 = new int[] { 3, -1,0,2};
        int[] arr3 = new int[] { 2, 3,1 ,5, -4};
        int[] arr4 = new int[]{-2,5,0,2,-2};
        int[] arr5 = new int[]{-4, -2, -3};
        OnethousandAndFive onethousandAndFive = new OnethousandAndFive();
        int result = onethousandAndFive.largestSumAfterKNegations(arr3, 2);
        System.out.println(result);
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int revertCount = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] <0 ) {
                nums[i] = -1 *nums[i];
                revertCount ++;
            }
            if(revertCount==k) {
                break;
            }
        }
        if (revertCount < k) {
            Arrays.sort(nums);
            for(int j=0; j<k-revertCount; j++) {
                nums[0] = -1 *nums[0];
            }
        }
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
