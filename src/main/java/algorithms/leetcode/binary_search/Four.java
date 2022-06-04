package algorithms.leetcode.binary_search;

public class Four {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length> nums2.length) {
            int[] tmp = nums2;
            nums2 = nums1;
            nums1 = tmp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int globalMid = (m+n+1)/2;

        int left = 0;
        int right = m;
        while (left<right) {
            int i = left + (right-left+1)/2;
            int j = globalMid - i;
            if(nums1[i-1] > nums2[j]) {
                right = i-1;
            }else {
                left = i;
            }
        }

        int i = left + (right-left+1)/2;
        int j = globalMid - i;
        int nums1Left = i==0?Integer.MIN_VALUE:nums1[i-1];
        int nums1Right = i==m?Integer.MAX_VALUE:nums1[i];
        int nums2Left = j==0?Integer.MIN_VALUE:nums2[j-1];
        int nums2Right = j==n?Integer.MAX_VALUE:nums2[j];

        if((m+n) % 2 == 0) {
            return (double) (Math.max(nums1Left, nums2Left)+Math.min(nums1Right, nums2Right))/2;
        }else{
            return Math.max(nums1Left, nums2Left);
        }
    }
}
