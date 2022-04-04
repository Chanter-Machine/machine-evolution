package algorithms.leetcode.interval_sum;

public class ThreehundardAndSeven {

    public static void main(String[] args) {
        NumArray1 numArray1 = new NumArray1(new int[]{-1});
        numArray1.update(0,1);
        numArray1.sumRange(0,0);
    }
}

class NumArray1 {
    int[] blockSum;
    int blockSize;
    int blocks;
    int[] nums;
    public NumArray1(int[] nums) {
        this.nums = nums;
        blockSize = (int)Math.sqrt(nums.length);
        blocks = nums.length / blockSize;
        if(nums.length % (int)Math.sqrt(nums.length) !=0) {
            blocks += 1;
        }
        blockSum = new int[blocks];

        for(int i=0; i< nums.length; i++) {
            blockSum[i/blockSize] += nums[i];
        }
    }

    public void update(int index, int val) {
        blockSum[index/blockSize] -= this.nums[index];
        blockSum[index/blockSize] += val;
        this.nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int leftBlock = left/blockSize;
        int rightBlock = right/blockSize;
        if(leftBlock == rightBlock) {
            int sum = 0;
            for(int i=left; i<=right; i++) {
                sum += this.nums[i];
            }
            return sum;
        }
        int sum1 = 0;
        for(int i=left; i<blockSize*(leftBlock+1); i++) {
            sum1 += nums[i];
        }
        int sum2 = 0;
        for(int i=leftBlock+1; i<rightBlock; i++) {
            sum2 += this.blockSum[i];
        }
        int sum3 = 0;
        for(int i=blockSize*rightBlock; i<= right; i++) {
            sum3 += this.nums[i];
        }
        return sum1+sum2+sum3;
    }
}
