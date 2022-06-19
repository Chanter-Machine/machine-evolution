package algorithms.leetcode.two_pointer;

public class Eleven {
    public int maxContainer(int[] height) {
        int len = height.length;
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left<right) {
            int contains = (right-left) * Math.min(height[left], height[right]);
            max = Math.max(max, contains);
            if( height[left]>= height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }
}
