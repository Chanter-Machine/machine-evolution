package algorithms.newcoder;

import java.util.Scanner;

public class Task106 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputStr = sc.nextLine();
        if (inputStr.length() >0) {
            for(int i=inputStr.length()-1; i>=0; i--){
                System.out.print(inputStr.charAt(i));
            }
        }
    }
}
