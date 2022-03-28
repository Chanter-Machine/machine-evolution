package algorithms.leetcode.dynamicProgramming;

public class SevenhundardAndSeventeen {
    public static void main(String[] args) {
        SevenhundardAndSeventeen sevenhundardAndSeventeen = new SevenhundardAndSeventeen();
        int[] bits = new int[] {0,0};
        boolean res = sevenhundardAndSeventeen.isOneBitCharacter(bits);
        System.out.println(res);
    }
    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length == 1 ) {
            return bits[0] != 1;
        }
        int left = 0;
        int right =1;
        int size = bits.length;

        while (right+2<size) {
            if(bits[left] ==0 && bits[right] ==1) {
                left++;
                right++;
            }else{
                left+=2;
                right+=2;
            }
        }
        if(right == size -1) {
            return bits[left] == 0;
        }else if(right == size -2) {
            if(bits[left] ==0 &&bits[right] ==1 ) {
                return false;
            }
            return bits[size - 1] == 0;
        }
        return false;
    }
}
