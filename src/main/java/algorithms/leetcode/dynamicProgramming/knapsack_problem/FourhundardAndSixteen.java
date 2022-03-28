package algorithms.leetcode.dynamicProgramming.knapsack_problem;

public class FourhundardAndSixteen {
    public static void main(String[] args) {
        int[] arr = new int[] {1,5,11,5};
        FourhundardAndSixteen fourhundardAndFifteen = new FourhundardAndSixteen();
        fourhundardAndFifteen.canPartition(arr);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum +=  nums[i];
        }
        if(sum %2 == 1) {
            return false;
        }
        int target = sum/2;
        int size = nums.length;
        boolean[][] dp = new boolean[size+1][target+1];
        for(int i=0; i<=size; i++) dp[i][0] = true;
        for(int i=1; i<=size; i++) {
            for(int j=1; j<=target; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i-1]) {
                    dp[i][j] |= dp[i-1][j-nums[i-1]];
                    System.out.print(dp[i][j] + " ");
                }
            }
            System.out.println();
        }
        return dp[nums.length][target];
    }
}
