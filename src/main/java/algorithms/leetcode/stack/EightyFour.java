package algorithms.leetcode.stack;

import java.util.LinkedList;
import java.util.Stack;

public class EightyFour {
    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        int[] heights2 = new int[]{1,2,4,8};
        int[] heights3 = new int[]{2,1,2};
        int[] heights4 = new int[]{1,5,4,1,2};
        int[] heights5 = new int[]{4,2,0,3,2,5};
        EightyFour eightyFour = new EightyFour();
        System.out.println(eightyFour.largestRectangleArea(heights5));
    }

    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for(int i=0;i<heights.length;i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int index = stack.pop();
                int width = stack.isEmpty()? i:i-stack.peek()-1;
                area = Math.max(heights[index]*width, area);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();

            int width = stack.isEmpty()? heights.length:heights.length-stack.peek()-1;
            area = Math.max(area, width*heights[index]);
        }
        return area;
    }

    public int largestRectangleArea2(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            //弹出小于当前边的栈顶元素
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int idx = stack.pop();
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                res = Math.max(res, heights[idx] * width);
            }
            stack.push(i);
        }
        //栈中可能还存在元素，一个个弹出求其面积
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int width = stack.isEmpty() ? heights.length : heights.length - 1 - stack.peek();
            res = Math.max(res, heights[idx] * width);
        }
        return res;
    }


}
