package algorithms.leetcode.sliding_window;

import algorithms.leetcode.string.Six;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SIxteenNinetyFive {
    public static void main(String[] args) {
        SIxteenNinetyFive sIxteenNinetyFive = new SIxteenNinetyFive();
        int res = sIxteenNinetyFive.maximumUniqueSubarray2(new int[] {4,2,4,5,6});
        System.out.println(res);
    }
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int res = 0;
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < nums.length) {
            int countRight = map.getOrDefault(nums[right], 0);
            if(countRight == 0) {
                map.put(nums[right], 1);
                sum += nums[right];
                res = Math.max(res, sum);
            }else if(countRight == 1) {
                while (left< right) {
                    sum -= nums[left];
                    map.remove(nums[left]);
                    if(nums[left++] == nums[right]) {
                        map.put(nums[right], 1);
                        sum += nums[right];
                        res = Math.max(res, sum);
                        break;
                    }
                }
            }
            right++;
        }
        return res;
    }

    public int maximumUniqueSubarray2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, sum = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                sum += nums[i];
                max = Math.max(sum, max);
            } else {
                while (nums[i] != nums[start]) {
                    sum -= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
                start++;
            }
        }
        return max;
    }

}
