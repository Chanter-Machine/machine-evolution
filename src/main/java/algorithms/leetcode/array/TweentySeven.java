package algorithms.leetcode.array;

public class TweentySeven {
    public static void main(String[] args) {
        int[] nums1 = new int []{3,2,2,3};
        int[] nums2 = new int []{3};

        int[] nums = nums2;
        TweentySeven tweentySeven = new TweentySeven();
        int len = tweentySeven.removeElement(nums, 3);

        for(int i=0;i<len;i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int removeElement(int[] nums, int val) {
        int originLen = nums.length;

        int left = 0;
        int right = originLen -1;
        int switchCount = 0;
        while(left < right) {
            if(nums[left] == val && nums[right]!=val) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left ++;
                right--;
                switchCount ++;
            }else if(nums[left] != val && nums[right]!=val) {
                left ++;
            }else if(nums[left] == val && nums[right]==val) {
                right --;
                switchCount++;
            }else if(nums[left] != val && nums[right]==val){
                left ++;
                right --;
                switchCount++;
            }
        }

        if (left == right && nums[left]== val) {
            switchCount ++;
        }

        return originLen - switchCount;
    }
}
