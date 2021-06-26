package algorithms.leetcode.stack;

import java.util.Stack;

public class OnehundardAndTwentyOne {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices2 = new int[]{7,6,4,3,1};
        int[] prices3 = new int[]{1,2};
        OnehundardAndTwentyOne onehundardAndTwentyOne = new OnehundardAndTwentyOne();
        System.out.println(onehundardAndTwentyOne.maxProfit(prices3));
    }

    public int maxProfit(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int tempMin = 0;
        int tempMaxProfit = 0;
        for(int i=0; i<prices.length;i++) {
            if(stack.isEmpty()) {
                stack.push(prices[i]);
                tempMin = prices[i];
                continue;
            }
            if(stack.peek()<prices[i]){
                stack.push(prices[i]);
            }else {
                int popCount = 1;
                while (!stack.isEmpty() && stack.peek()>prices[i]){
                    if(popCount == 1) {
                        int tempMax = stack.pop();
                        tempMaxProfit = tempMax-tempMin>tempMaxProfit?tempMax-tempMin:tempMaxProfit;
                        popCount++;
                        continue;
                    }
                    stack.pop();
                }
                stack.push(prices[i]);
                if(stack.size() ==1) {
                    tempMin = prices[i];
                }
            }
        }

        tempMaxProfit = stack.peek()-tempMin>tempMaxProfit?stack.peek()-tempMin:tempMaxProfit;

        return tempMaxProfit;
    }
}
