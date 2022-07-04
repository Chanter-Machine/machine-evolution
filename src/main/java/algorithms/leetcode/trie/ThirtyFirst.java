package algorithms.leetcode.trie;

public class ThirtyFirst {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3};
//        int[] arr = new int[]{3,2,1};
        int[] arr = new int[]{1,5,1};
        ThirtyFirst thirtyFirst = new ThirtyFirst();
        thirtyFirst.nextPermutation(arr);
    }
    public void nextPermutation(int[] nums) {

        int size = nums.length;
        if(size<2) {
            return ;
        }
        int k = size -2;
        while(k >0 && nums[k]>nums[k+1]) {
            k--;
        }

        int m = size-1;
        while (m >0 && nums[m]<=nums[k]) {
            m--;
        }
        if(m !=k) {
            swap(nums, k, m);
            reverseAll(nums, k+1, size-1);
            return ;
        }
        reverseAll(nums, 0, size-1);
    }

    public void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public void reverseAll(int[] arr, int left, int right) {
        int len = right - left;
        for (int i=0; i<= (len/2); i++) {
            int tmp = arr[left+i];
            arr[left+i] = arr[right-i];
            arr[right-i] = tmp;
        }
    }
}
