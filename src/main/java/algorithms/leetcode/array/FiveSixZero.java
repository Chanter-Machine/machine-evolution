package algorithms.leetcode.array;

public class FiveSixZero {
    public int subarraySum(int[] nums, int k) {
        int leftPointer= 0;
        int rightPointer=0;

        int length = nums.length;

        int count = 0;

        int temp = nums[0];
        while(leftPointer<length && rightPointer<length){
            if(temp<=k){
                if(temp==k) {
                    count++;
                }
                if(rightPointer<length-1){
                    temp+=nums[++rightPointer];
                }else{
                    temp -= nums[leftPointer++];
                }
            }else if(temp>k){
                temp -= nums[leftPointer++];
            }

            if(rightPointer==length && leftPointer==length){
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FiveSixZero fiveSixZero = new FiveSixZero();
//        int [] arr = new int[]{1,1,1};
//        int k = 2;

//        int [] arr = new int[]{1,2,3};
//        int k = 3;

        int [] arr = new int[]{28,54,7,-70,22,65,-6};
        int k = 100;

        int result = fiveSixZero.subarraySum(arr, k);
        System.out.println(result);
    }
}

