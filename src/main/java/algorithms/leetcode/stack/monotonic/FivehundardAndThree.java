package algorithms.leetcode.stack.monotonic;

import java.util.Stack;

public class FivehundardAndThree {
    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        for(int i=nums.length-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek()<= nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        int[] res = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek()<= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,1,4,3};
        FivehundardAndThree fivehundardAndThree = new FivehundardAndThree();
        fivehundardAndThree.nextGreaterElements2(arr);
    }

    public int[] nextGreaterElements2(int[] nums) {
        int n=nums.length;
        Stack<Integer> s=new Stack<>();
        int[] res=new int[n];
        for(int i=2*n-1;i>=0;i--){
            while(!s.empty() && s.peek()<=nums[i%n]){
                s.pop();
            }
            if(s.empty()){
                res[i%n]=-1;
            } else {
                res[i%n]=s.peek();
            }
            s.push(nums[i%n]);
        }
        return res;
    }

}
