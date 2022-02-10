package algorithms.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

public class TwothousandAndTwo {
    public static void main(String[] args) {
        TwothousandAndTwo twothousandAndTwo = new TwothousandAndTwo();
        twothousandAndTwo.countKDifference(new int[]{1,3}, 3);
    }
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++) {
            int tmpCount = map.getOrDefault(nums[i], 0);
            map.put(nums[i], tmpCount+1);
        }
        if(map.size() <= 1) {
            return 0;
        }
        int[] arr = new int[map.size()];
        int i=0;
        for(Integer num : map.keySet()){
            arr[i++] = num;
        }
        Arrays.sort(arr);
        int left = 0;
        int right = 1;
        while ( right<arr.length) {
            while (left < right){
                if(arr[right] - arr[left] == k) {
                    count += map.get(arr[right]) * map.get(arr[left]);
                    break;
                }else if (arr[right] - arr[left] >k) {
                    left++;
                }else {
                    break;
                }
            }
            right++;
        }
        return count;
    }

    public int countKDifference2(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            res += map.getOrDefault(nums[i]-k, 0) + map.getOrDefault(nums[i]+k, 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        return res;
    }
}
