package algorithms.leetcode.math;

public class ThirteenFourtyTwo {
    public static void main(String[] args) {

    }

    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            int rest = num %2;
            if(rest == 1) {
                num--;
                count++;
                continue;
            }
            num /=2;
            count++;
        }
        return count;
    }
}
