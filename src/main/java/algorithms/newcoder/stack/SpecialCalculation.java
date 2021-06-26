package algorithms.newcoder.stack;

import java.util.Stack;

public class SpecialCalculation {
    public static void main(String[] args) {

    }

    public int calculation(String input) {
        char[] inputArray = input.toCharArray();

        Stack<Integer> numStack = new Stack<>();
        char op = ' ';
        for(int i=0; i<inputArray.length;) {
            char ch = inputArray[i];
            if (ch== '$') {
                i++;
                continue;
            }
            if (ch=='#') {
                int numFromStack = numStack.pop();
                numStack.push(numFromStack*2+ inputArray[i+1]);
                i+=2;
                continue;
            }
            numStack.push(Integer.parseInt(inputArray[i]+""));
            i++;
        }
        int sum = 0;
        while (!numStack.isEmpty()) {

        }
        return 0;
    }
}
