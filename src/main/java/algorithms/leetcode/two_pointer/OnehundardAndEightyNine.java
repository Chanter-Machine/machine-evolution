package algorithms.leetcode.two_pointer;

public class OnehundardAndEightyNine {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        OnehundardAndEightyNine onehundardAndEightyNine = new OnehundardAndEightyNine();
        onehundardAndEightyNine.rotate(nums,3);
    }

    public void rotate(int[] nums, int k) {
        if(nums.length == 1) {
            return;
        }
        int mod = k% nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, mod-1);
        reverse(nums, mod, nums.length-1);
    }
    private void reverse(int[] nums, int left, int right) {
        int len = right - left +1;
        for(int i=0; i<len/2; i++) {
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left]=tmp;
            left++;
            right--;
        }
    }
}
