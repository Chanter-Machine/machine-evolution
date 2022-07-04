package algorithms.leetcode.sliding_window;

import java.util.HashMap;

public class FivehundardAndSixty {

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,3,3,3,3,4,5,6};
        FivehundardAndSixty fivehundardAndSixty = new FivehundardAndSixty();
        int res = fivehundardAndSixty.findLeftBound(arr, 0, arr.length-1, 3);
        System.out.println(res);

        int res2 = fivehundardAndSixty.findRightBound(arr, 0, arr.length-1, 3);
        System.out.println(res2);
    }

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int cnt = 0;
        int[] sums = new int[len+1];
        sums[0] = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++) {
            sums[i+1] = nums[i] + sums[i];
//            if(nums[i] == k) {
//                cnt++;
//            }
            if(sums[i+1] == k) {
                cnt++;
            }
                int prevSum = sums[i+1] - k;
                int prev = map.getOrDefault(prevSum, 0);
                cnt += prev;

            int tmpCount = map.getOrDefault(sums[i+1], 0);
            map.put(sums[i+1], tmpCount+1);
        }
        return cnt;
    }

    private int findLeftBound(int[] arr, int left, int right, int target){
        while (left<right) {
            int mid = left + (right - left) /2;
            if(arr[mid] < target) {
                left = mid+1;
            }else {
                right = mid;
            }
        }
        if(arr[left] == target) {
            return left;
        }
        return  -1;
    }

    private int findRightBound(int[] arr, int left, int right, int target){
        while (left<right) {
            int mid = left + (right - left+1) /2;
            if(arr[mid] > target) {
                right = mid -1;
            }else {
                left = mid;
            }
        }
        if(arr[left] == target) {
            return left;
        }
        return  -1;
    }

}
