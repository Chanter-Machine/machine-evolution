package algorithms.codility;

import java.util.Stack;

public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.solution(529);
    }
    public int solution(int N) {
        // write your code in Java SE 8
        Stack<Integer> stack = new Stack<>();
        int prev = -1;
        int count = -1;
        int max = 0;
        while ( N!=0) {
            count++;
            int mod = N%2;
            if(mod == 1) {
                if (prev != -1) {
                    max = Math.max(max, count-prev-1);
                }
                prev = count;
            }
            N /=2;
        }

        return max;
    }
}
