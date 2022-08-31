package algorithms.leetcode.stack;

import java.util.Stack;

public class NinehundardAndFourtySix {
    public static void main(String[] args) {
        int[] push = new int[] {1,2,3,4,5};
        int[] pop = new int[] {4,5,3,2,1};
        NinehundardAndFourtySix ninehundardAndFourtySix = new NinehundardAndFourtySix();
        boolean res = ninehundardAndFourtySix.validateStackSequences(push, pop);
        System.out.println(res);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int pushPointer = 0;
        int popPointer = 0;

        int len = pushed.length;
        while (true) {
            while ((stack.isEmpty() || stack.peek() != popped[popPointer]) && pushPointer<len) {
                stack.push(pushed[pushPointer++]);
            }

            while (!stack.isEmpty() && stack.peek() == popped[popPointer] && popPointer<len) {
                stack.pop();
                popPointer++;
            }
            if( pushPointer>= len ) {
                break;
            }
        }
        if(popPointer<len) {
            return false;
        }
        return true;

    }
}
