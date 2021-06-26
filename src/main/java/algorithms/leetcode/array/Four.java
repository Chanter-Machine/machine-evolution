package algorithms.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Four {
    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int left = 0;
        int right = 0;
        boolean isOdd = false;
        if(total % 2 == 0) {
            left = total/2-1;
            right = left ;
        }else {
            left = total/2;
            isOdd = true;
        }
        int[] nums = nums1.length>nums2.length?nums2:nums1;
        int[] numsLarger = nums1.length<=nums2.length?nums2:nums1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++) {
            queue.offer(nums[i]);
        }
        for(int i=0;i<numsLarger.length;i++) {

            if(queue.peek()<=numsLarger[i]) {
//                if(queue.size()< )
            }
        }


        return 0.0;
    }
}

