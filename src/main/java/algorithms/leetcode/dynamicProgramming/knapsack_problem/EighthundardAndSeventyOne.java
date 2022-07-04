package algorithms.leetcode.dynamicProgramming.knapsack_problem;

public class EighthundardAndSeventyOne {
    public static void main(String[] args) {
        int target = 100;
        int startFuel = 10;
        int[][] stations = new int[][]{{10,60},{20,30},{30,30},{60,40}};
        EighthundardAndSeventyOne eighthundardAndSeventyOne = new EighthundardAndSeventyOne();
        int res = eighthundardAndSeventyOne.minRefuelStops(target, startFuel, stations);
        System.out.println(res);
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int[] dp = new int[stations.length+1];
        dp[0] = startFuel;

        for(int i=0; i<stations.length; i++) {
            for(int j=i; j>=0; j--) {
                if(dp[j] >= stations[i][0]) {
                    dp[j+1] = Math.max(dp[j+1], dp[j]+ stations[i][1]);
                }
            }
        }

        for(int i=0; i< dp.length; i++) {
            if(dp[i]>=target) {
                return i;
            }
        }
        return -1;
    }
}
