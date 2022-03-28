package algorithms.leetcode.two_pointer;

public class TwohundardAndTwo {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = calc(n);
        while (true) {
            if(slow == 1) {
                return true;
            }
            if(slow == fast) {
                return false;
            }
            slow = calc(slow);
            fast = calc(calc(fast));

        }
    }

    public int calc(int num) {
        int res = 0;
        while (num != 0) {
            int rest = num%10;
            num = num/10;
            res += rest*rest;
        }
        return  res;
    }
}
