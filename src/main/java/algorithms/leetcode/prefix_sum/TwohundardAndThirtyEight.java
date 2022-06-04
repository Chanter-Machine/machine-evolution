package algorithms.leetcode.prefix_sum;


public class TwohundardAndThirtyEight {
    public static void main(String[] args) {
        TwohundardAndThirtyEight twohundardAndThirtyEight = new TwohundardAndThirtyEight();
        twohundardAndThirtyEight.productExceptSelf(new int[]{-1,1,0,-3,3});
    }
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] productLeft = new int[len+1];
        int[] productRight = new int[len+1];
        productLeft[0] = 1;
        productRight[len] = 1;
        for(int i=0; i<len; i++) {
            productLeft[i+1] = productLeft[i] * nums[i];
            productRight[len-i-1] = productRight[len-i] * nums[len-1-i];
        }

        int[] res = new int[len];
        for(int i=0; i<len; i++) {
            res[i] = productLeft[i] * productRight[i+1];
        }

        return res;
    }
}
