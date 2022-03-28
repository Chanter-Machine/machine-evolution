package algorithms.leetcode.sliding_window;

public class TwohundardAndNine {
    public static void main(String[] args) {
        int[] arr = new int[] {2,3,1,2,4,3};
        TwohundardAndNine twohundadAndNine = new TwohundardAndNine();
        int res = twohundadAndNine.minSubArrayLen(7, arr);
        System.out.println(res);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (right< nums.length) {
            sum+=nums[right];
            while (sum>= target) {
                res = Math.min(res, right-left+1);
                sum -= nums[left++];
            }
            right++;
        }

        return (res==Integer.MAX_VALUE)?0:res;
    }
}
