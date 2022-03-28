package algorithms.leetcode.binary_search;

import java.util.Arrays;

public class FourhundardAndTen {

    public int splitArray(int[] nums, int m) {
        int max = Arrays.stream(nums).sum();
        int min = Arrays.stream(nums).max().getAsInt();

        return binarySearch(nums, m, min, max);
    }

    public int binarySearch(int[] nums, int m, int min, int max)  {
        while (min<max) {
            int mid = min + (max - min) /2;
            if(!validate(nums, m, mid)) {
                min = mid +1;
            }else {
                max = mid;
            }
        }
        return min;
    }

    public boolean validate(int[] nums, int m, int guess) {
        int count = 1;
        int tmpSum = 0;
        for(int num : nums) {
            tmpSum += num;
            if(tmpSum>guess) {
                count++;
                tmpSum = num;
            }
            if(count>m) {
                return false;
            }
        }
        return true;
    }
}
