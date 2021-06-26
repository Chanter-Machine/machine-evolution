package algorithms.leetcode.array;

public class Eleven {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;

        int area = 0;
        while(left<right) {
            int tempArea = (right - left) * Math.min(height[left], height[right]);
            if (tempArea>area) {
                area = tempArea;
            }
            if (height[left]<=height[right]) {
                left++;
            }else {
                right--;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        Eleven eleven = new Eleven();
        int [] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(eleven.maxArea(arr));
    }

}
