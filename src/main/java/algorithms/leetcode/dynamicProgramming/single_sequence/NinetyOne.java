package algorithms.leetcode.dynamicProgramming.single_sequence;

public class NinetyOne {
    public static void main(String[] args) {
        NinetyOne ninetyOne = new NinetyOne();
        ninetyOne.numDecodings("12");
    }
    public int numDecodings(String s) {
        if(s.charAt(0) == '0' ) return 0;
        if (s.length() ==1) return 1;
        int res = 0;
        int minus2 = 1;
        int minus1 = 0;

        if((s.charAt(0)-'0')*10 + (s.charAt(1)-'0')<= 26 && (s.charAt(0)-'0')*10 + (s.charAt(1)-'0')>=10 ) {
            res ++;
        }
        if(s.charAt(1) != '0') {
            res ++;
        }
        if (res == 0) {
            return 0;
        }
        minus1 = res;
        for(int i=2; i<s.length(); i++) {
            if(s.charAt(i)-'0' == 0) {
                res = 0;
            }else {
                res = minus1;
            }
            int tmp = (s.charAt(i-1)-'0')*10 + (s.charAt(i)-'0');
            if(tmp <= 26 && tmp>= 10) {
                res += minus2;
            }
            if( res == 0) {
                return 0;
            }
            minus2 = minus1;
            minus1 = res;
        }

        return res;
    }
}
