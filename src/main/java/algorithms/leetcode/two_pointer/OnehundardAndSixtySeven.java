package algorithms.leetcode.two_pointer;

public class OnehundardAndSixtySeven {
    public static void main(String[] args) {
        int[] arr = new int[] {2,7, 11,15};
        OnehundardAndSixtySeven onehundardAndSixtySeven = new OnehundardAndSixtySeven();
        int[] res = onehundardAndSixtySeven.twoSum(arr, 9);
        for(int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }

    }
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (true) {
            int res = numbers[left] + numbers[right];
            if(res < target) {
                left ++;
            }else if(res>target) {
                right--;
            }else {
                return new int[] {left+1, right+1};
            }
        }
    }
}
