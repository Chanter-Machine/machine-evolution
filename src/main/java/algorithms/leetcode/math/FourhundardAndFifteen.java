package algorithms.leetcode.math;

import algorithms.leetcode.array.FourHandardFortyTwo;

import java.util.Stack;

public class FourhundardAndFifteen {
    public static void main(String[] args) {
        FourhundardAndFifteen fourhundardAndFifteen = new FourhundardAndFifteen();
        String str1 = "123";
        String str2 = "321";
        fourhundardAndFifteen.addStrings(str1, str2);
    }

    public String addStrings(String num1, String num2) {
        num1 = new StringBuffer(num1).reverse().toString();
        num2 = new StringBuffer(num2).reverse().toString();
        char[] arr1 = num1.toCharArray();

        char[] arr2 = num2.toCharArray();

        int maxLen = Math.max(arr1.length, arr2.length);
        int promotion = 0;
        StringBuffer res = new StringBuffer();
        for(int i=0; i<maxLen;i++) {

            int curRes =  promotion;
            if(i<arr1.length) {
                curRes += (arr1[i] - '0');
            }
            if(i<arr2.length) {
                curRes +=  arr2[i] - '0';
            }
            if (curRes > 9) {
                curRes -= 10;
                promotion = 1;
            }else{
                promotion = 0;
            }
            res.append( curRes);
        }
        if (promotion != 0 ) {
            res.append( promotion);
        }
        return res.reverse().toString();

    }
}
