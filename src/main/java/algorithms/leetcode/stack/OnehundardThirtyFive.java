package algorithms.leetcode.stack;

import java.util.Stack;

public class OnehundardThirtyFive {
    public static void main(String[] args) {
        int[] ratings0 = new int[]{1,0,2};
        int[] ratings1 = new int[]{1,2,2};
        int[] ratings2 = new int[]{1,3,2,2,1};
        int[] ratings3 = new int[]{1,2,87,87,87,2,1};
        int[] ratings4 = new int[]{1,2,3,1,0};
        OnehundardThirtyFive onehundardThirtyFive = new OnehundardThirtyFive();
        System.out.println(onehundardThirtyFive.candy2(ratings4));
    }

//    by stack
    public int candy(int[] ratings) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<ratings.length;i++) {
            if(stack.isEmpty()) {
                stack.push(1);
                continue;
            }
            if(ratings[i]>ratings[i-1]){
                stack.push(stack.peek()+1);
            }else if(ratings[i]==ratings[i-1]){
                stack.push(1);
            }else {
                if(stack.peek()>1){
                    stack.push(1);
                }else{
                    int j = i;
                    Stack<Integer> tempStack = new Stack<>();
                    while(j>=1 && ratings[j]<ratings[j-1]) {
                        tempStack.push(stack.pop());
                        if(!stack.isEmpty() && stack.peek() > tempStack.peek()+1){
                            break;
                        }
                        j--;
                    }
                    while (!tempStack.isEmpty()){
                        stack.push(tempStack.pop()+1);
                    }
                    stack.push(1);
                }
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

//    By Greedy
    public int candy2(int[] ratings) {
        int[] fromLeft = new int[ratings.length];
        int[] fromRight = new int[ratings.length];

        for(int i=0;i<ratings.length;i++) {
            fromLeft[i] = 1;
            fromRight[ratings.length-1-i] = 1;
            if(i>0) {
                if(ratings[i]>ratings[i-1]){
                    fromLeft[i] = fromLeft[i-1]+1;
                }
                if(ratings[ratings.length-1-i]>ratings[ratings.length-i]){
                    fromRight[ratings.length-1-i] = fromRight[ratings.length-i]+1;
                }
            }
        }
//        int[] result = new int[ratings.length];
        int sum = 0;
        for(int i=0;i<ratings.length;i++) {
            sum += Math.max(fromLeft[i], fromRight[i]);
        }
        return sum;
    }
}
