package algorithms.leetcode.math;

public class Nine {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(int x) {
        if (x<0) {
            return false;
        }

        char[] arr = (x+"").toCharArray();
        int i=0, j=arr.length-1;
        while (i<=j) {
            if(arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x<0) {
            return false;
        }

        int current = 0;
        int num = x;
        while (num !=0) {
            current = current *10 + num%10;
            num /= 10;
        }
        return current == x;
    }
}
