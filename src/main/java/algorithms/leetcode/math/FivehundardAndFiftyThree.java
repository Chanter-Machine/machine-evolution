package algorithms.leetcode.math;

public class FivehundardAndFiftyThree {

    public static void main(String[] args) {
//        int[] nums = new int[] {1000,100,10,2};
        int[] nums = new int[] {2,3,4};
        FivehundardAndFiftyThree fivehundardAndFiftyThree = new FivehundardAndFiftyThree();
        String res = fivehundardAndFiftyThree.optimalDivision(nums);
        System.out.println(res);
    }
    public String optimalDivision(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0] + "";
        }else if (len == 2) {
            return nums[0]+"/"+nums[1];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/(");
        for(int i=1; i<len-1;i++) {
            sb.append(nums[i]).append('/');
        }
        sb.append(nums[len-1]).append(')');

        return sb.toString();
    }
}
