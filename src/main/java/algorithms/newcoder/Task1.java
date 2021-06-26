package algorithms.newcoder;

import java.util.Scanner;
import java.util.Stack;

public class Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] arr = input.split(" ");

        if (arr.length == 0) {
            System.out.println(0);
        }else {
            String lastString = arr[arr.length-1];
            System.out.println(lastString.length());
        }
    }

    public static void solution2(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        if (input.length() == 0) {
            System.out.println(0);
        }
        Stack<String> stack = new Stack<>();
        for(int i=input.length()-1; i>=0; i--) {
            String tempStr =  input.substring(i, i+1);
            if (!tempStr.equals(" ")) {
                stack.push(input.substring(i, i+1));
            }else {
                break;
            }

        }

    }
}
