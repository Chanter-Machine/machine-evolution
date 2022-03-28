package algorithms.leetcode.bit_op;

public class SixhundardAndNinetyThree {
    public boolean hasAlternatingBits(int n) {
        int flag = (n & 1)==0?0:1;
        n = n>>1;
        while (n >0) {
            int newFlag = (n & 1)==0?0:1;
            if(flag == newFlag) {
                return false;
            }
            flag = newFlag;
            n = n>>1;
        }
        return true;
    }
}
