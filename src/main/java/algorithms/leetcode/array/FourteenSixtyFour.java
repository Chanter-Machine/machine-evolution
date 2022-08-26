package algorithms.leetcode.array;

public class FourteenSixtyFour {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondary = Integer.MIN_VALUE;
        for(int num : nums) {
            if(num >= max) {
                secondary = max;
                max = num;
                continue;
            }
            if( num>=secondary) {
                secondary = num;
            }
        }

        return (max-1)*(secondary-1);
    }
}
