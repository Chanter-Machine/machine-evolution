package algorithms.leetcode.dynamicProgramming;

public class SevenHundardFourtySix {

    public static void main(String[] args) {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};     //6
        int [] cost1 = new int[]{10, 15, 20};
        int [] cost2 = new int[]{0,0,1,2};
        int [] cost3 = new int[]{0,1,1,0};
        int [] cost4 = new int[]{0,0,1,1};  // 1
        SevenHundardFourtySix sevenHundardFourtySix = new SevenHundardFourtySix();
        System.out.println(sevenHundardFourtySix.minCostClimbingStairs(cost3));
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;

        if (len == 2) {
            return Math.min(cost[0], cost[1]);
        }else {
            int[] sum =  new int[len+1];
            sum[0] = 0;
            sum[1] = 0;
            for(int i=2; i<=len; i++) {
                sum[i] = Math.min(sum[i-2]+ cost[i-2], sum[i-1]+cost[i-1]);
            }
            return sum[len];
        }
    }
}
