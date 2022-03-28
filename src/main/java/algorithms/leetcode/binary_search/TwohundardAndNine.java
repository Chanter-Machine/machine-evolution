package algorithms.leetcode.binary_search;


public class TwohundardAndNine {
    public static void main(String[] args) {
        int[] arr = new int[] {2,3,1,2,4,3};
//        int[] arr = new int[] {1,2,3,4,5};
        TwohundardAndNine twohundadAndNine = new TwohundardAndNine();
        int res = twohundadAndNine.minSubArrayLen(7, arr);
        System.out.println(res);
    }
    public int minSubArrayLen(int target, int[] nums) {
        int left = 1;
        int right = nums.length;
        int res = 0;
        while (left<= right) {
            int mid = left + (right - left)/2;
            if(calc(target, mid, nums)) {
                res = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return res;
    }

    private boolean calc(int target, int len, int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(i - len >=0){
                sum -= nums[i-len];
            }
            if(sum>=target) {
                return true;
            }
        }
        return false;
    }
}
