package algorithms.leetcode.string;

public class ThirteenSeventyFour {
    public static void main(String[] args) {
        ThirteenSeventyFour thirteenSeventyFour = new ThirteenSeventyFour();
        System.out.println(thirteenSeventyFour.generateTheString(1));
        System.out.println(thirteenSeventyFour.generateTheString(2));
        System.out.println(thirteenSeventyFour.generateTheString(3));
        System.out.println(thirteenSeventyFour.generateTheString(4));
        System.out.println(thirteenSeventyFour.generateTheString(5));
        System.out.println(thirteenSeventyFour.generateTheString(6));
        System.out.println(thirteenSeventyFour.generateTheString(7));
        System.out.println(thirteenSeventyFour.generateTheString(8));
        System.out.println(thirteenSeventyFour.generateTheString(9));
    }
    public String generateTheString(int n) {
        if(n==1) {
            return "a";
        }

        StringBuilder sb = new StringBuilder(n);
        boolean isEven = n%2 == 0;
        if(isEven) {
            for(int i=0; i<n-1; i++) {
                sb.append('a');
            }
            sb.append('b');
            return sb.toString();
        }

        for(int i=0; i<n-2; i++) {
            sb.append('a');
        }
        sb.append('b');
        sb.append('c');
        return sb.toString();
    }
}
