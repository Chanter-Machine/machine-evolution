package algorithms.leetcode.math;

public class OnehundardAndSixtyNine {

    public static void main(String[] args) {
        int[] arr = new int[]{2,1};
//        int[] arr = new int[]{2,2,1,1,1,2,2};
//        int[] arr = new int[]{3,2,3};

        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {

        int vote = 0;
        int val = 0;
        for(int i=0;i< nums.length;i++) {
            if(vote>0 && val == nums[i]) {
                vote++;
            }else if (vote ==0) {
                vote++;
                val = nums[i];
            }else {
                vote--;
            }
        }

        return val;
    }

}
