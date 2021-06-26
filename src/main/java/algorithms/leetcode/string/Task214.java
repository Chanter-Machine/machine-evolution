package algorithms.leetcode.string;

public class Task214 {

        public static String shortestPalindrome(String s) {
            String ss = s + new StringBuilder(s).reverse().toString();
            for (int i=s.length(),j=i; i>0; i--,j++) {
                if (ss.substring(0, i).equals(ss.substring(j))) {
                    return new StringBuilder(s.substring(i)).reverse().append(s).toString();
                }
            }
            return "";
        }

    public static void main(String[] args) {
        String res = shortestPalindrome("aacecaaa");
        System.out.println(res);
    }
}
