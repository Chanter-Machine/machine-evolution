package algorithms.leetcode.array;

public class TwelveSeventeen {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        TwelveSeventeen twelveSeventeen = new TwelveSeventeen();
        twelveSeventeen.minCostToMoveChips(arr);
    }
    public int minCostToMoveChips(int[] position) {
        int len = position.length;

        int res = Integer.MAX_VALUE;
        for(int i=0; i<len; i++) {
            int tmpRes = 0;
            for(int j=0; j<len ;j++) {
                if(j==i) {
                    continue;
                }
                int distance = Math.abs(j-i);
                tmpRes += distance%2==0?0:position[j];
            }
            res = Math.min(res, tmpRes);
        }

        return res;
    }
}
