package algorithms.leetcode.string;

public class Seven {
    public static void main(String[] args) {
        Seven seven = new Seven();
        int input1 = 123;
        int input2 = -123;
        int input3 = 120;
        int input4 = 1534236469;
        System.out.println(seven.reverse(input4));
    }

    public int reverse(int x) {
        if(x == Integer.MIN_VALUE || x==0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder(x+"");
        if(sb.charAt(sb.length()-1) == '0') {
            sb.deleteCharAt(sb.length()-1);
        }
        sb.reverse();
        boolean minusFlag = false;
        if(sb.charAt(sb.length()-1) == '-'){
            sb.deleteCharAt(sb.length()-1);
            minusFlag = true;
        }
        int y = 0;
        try{
            y = Integer.parseInt(sb.toString());
        }catch (NumberFormatException e) {
            return 0;
        }
        if (minusFlag) {
            y *= -1;
        }
        return y;
    }

}
