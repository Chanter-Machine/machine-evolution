package algorithms.leetcode.array;

import java.util.Collections;

public class OnehundardAndFIftyOne {

    public static void main(String[] args) {
        String s = "hello world   ~~~";
        String[] arr = s.split(" ");
        System.out.println(arr);
    }
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i].equals("")) {
                continue;
            }
            sb.append(arr[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
