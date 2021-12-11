package algorithms.leetcode.array;

import java.util.Arrays;

public class TwohundardAndEightyThree {
    public static void main(String[] args) {
        int[] arr  = new int[] {0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(arr.toString());
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 0 ) {
            return;
        }

        int j = 0;
        for(int  i=0;i<nums.length && j<nums.length;i++) {
            while (j<nums.length ) {
                if(nums[j] == 0 ) {
                    j ++;
                    continue;
                }

                break;
            }
            if(nums[i] == 0) {
                nums[i] = nums[j];
                nums[j] = 0;
            }
            j++;

        }
    }

    public static void moveZeroes2(int[] nums) {
       int left = 0;
       int right = 0;
       while(right < nums.length) {
           if(nums[right] != 0) {
               swap(nums, left,right);
               left ++;
           }
           right ++;
       }
    }

    public static void swap(int[] arr, int left, int right ){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
