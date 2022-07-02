package algorithms.leetcode.two_pointer;

public class Eleven {
    public static void main(String[] args) {
        int[] arr = new int[] {1,8,6,2,5,4,8,3,7};
        Eleven eleven = new Eleven();
        int res =  eleven.maxContainer(arr);
        System.out.println(res);
    }
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
