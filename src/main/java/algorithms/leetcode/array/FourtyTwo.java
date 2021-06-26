package algorithms.leetcode.array;

import java.util.Stack;

public class FourtyTwo {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        FourtyTwo fourtyTwo = new FourtyTwo();
        System.out.println(fourtyTwo.trap(height));
    }

    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while(current<height.length) {
            while(!stack.isEmpty() && height[stack.peek()]<height[current]){
                int h = height[stack.peek()];
                int index = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                sum += (current - stack.peek()  - 1) * (Math.min(height[stack.peek()], height[current])-h);
            }

            stack.push(current++);
        }

        return sum;
    }
}
