package algorithms.leetcode.stack.monotonic;

import java.util.Stack;

public class SevenhundardAndThirtyNine {
    public int[] dailyTemperatures(int[] temperatures) {

        int[]res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=temperatures.length-1; i>=0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty()?0:(stack.peek()-i);
            stack.push(i);
        }
        return res;
    }
}
