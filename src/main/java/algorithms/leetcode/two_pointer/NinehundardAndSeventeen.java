package algorithms.leetcode.two_pointer;

public class NinehundardAndSeventeen {
    public static void main(String[] args) {
       String s =  "ab-cd";
       NinehundardAndSeventeen ninehundardAndSeventeen = new NinehundardAndSeventeen();
       String res = ninehundardAndSeventeen.reverseOnlyLetters(s);
        System.out.println(res);
    }

    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder();
        sb.setLength(s.length());
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() -1;

        while (left<= right) {
            if( !inRange(arr[left])) {
                sb.setCharAt(left, arr[left++]);
                continue;
            }
            if(!inRange(arr[right])) {
                sb.setCharAt(right, arr[right--]);
                continue;
            }
            char tmp = arr[left];
            sb.setCharAt(left, arr[right]);
            sb.setCharAt(right, tmp);
            right--;
            left++;
        }

        return sb.toString();
    }

    private boolean inRange(char c) {
        return (c >= 97 && c <= 122) || (c >= 65 && c <= 90);
    }
}
