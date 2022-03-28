package algorithms.leetcode.graph;

public class NinehundardAndNightySeven {

    public static void main(String[] args) {
        NinehundardAndNightySeven ninehundardAndNightySeven = new NinehundardAndNightySeven();
        ninehundardAndNightySeven.findJudge(2, new int[][]{{1,2}});
    }

    public int findJudge(int n, int[][] trust) {
        int[][] countArr = new int[n+1][2];

        for(int i=0; i<trust.length; i++) {

            countArr[trust[i][0]][0] ++;
            countArr[trust[i][1]][1] ++;
        }
        for(int i=1; i<=n; i++) {
            if(countArr[i][0] ==0 && countArr[i][1] == n-1) {
                return i;
            }
        }
        return -1;
    }
}
