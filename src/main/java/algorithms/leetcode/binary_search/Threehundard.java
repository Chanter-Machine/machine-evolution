package algorithms.leetcode.binary_search;

import java.util.ArrayList;

public class Threehundard {
    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,2,3};

        Threehundard threehundard = new Threehundard();
        threehundard.lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        ArrayList<Integer> increArr = new ArrayList<>();
        increArr.add(nums[0]);
        for(int i=1; i< nums.length; i++) {
            int last = increArr.get(increArr.size()-1);
            if(nums[i] > last) {
                increArr.add(nums[i]);
                continue;
            }
//            for(int j=0; j< increArr.size(); j++) {
//                if(nums[i]<increArr.get(j)) {
//                    increArr.set(j, nums[i]);
//                    break;
//                }
//            }
            int leftBoundIndex = findLeftBound(increArr, nums[i]);
            if(leftBoundIndex != -1 ) {
                increArr.set(leftBoundIndex, nums[i]);
            }
        }

        return increArr.size();
    }

    private int findLeftBound(ArrayList<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() -1 ;
        while (left < right ) {
            int mid = left+ (right - left) /2;
            if(arr.get(mid) < target) {
                left = mid +1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
