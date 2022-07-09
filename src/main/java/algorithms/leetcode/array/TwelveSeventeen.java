package algorithms.leetcode.array;

public class TwelveSeventeen {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        TwelveSeventeen twelveSeventeen = new TwelveSeventeen();
        int res = twelveSeventeen.minCostToMoveChips(arr);
        System.out.println(res);
    }
    public int minCostToMoveChips(int[]  position) {
        int len = position.length;
        int[] result = new int[position.length];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++) {
                if(j == i) {
                    continue;
                }
                if(Math.abs(position[j]-position[i])%2==1) {
                    result[i] += 1;
                }
            }
            min = Math.min(min, result[i]);

        }

        return  min;
    }

    public int minCostToMoveChips2(int[]  position) {
        int len = position.length;
        int even = 0;
        int odd = 0;
        for(int i=0; i<len; i++) {
            if(position[i]%2 == 0){
                even++;
            }else {
                odd++;
            }
        }

        return  Math.min(even, odd);
    }
}
