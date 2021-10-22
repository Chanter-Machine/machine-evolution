package algorithms.leetcode.math;

import java.util.*;

public class TwoHundardAndTwentyNine {

    public static void main(String[] args) {
        TwoHundardAndTwentyNine twoHundardAndTwentyNine = new TwoHundardAndTwentyNine();

//        int[] arr = new int[]{2};
//        int[] arr = new int[]{1,1,1,3,3,2,2,2};
        int[] arr = new int[]{3,2,3};
//        int[] arr = new int[]{2,3};
        List<Integer> res =  twoHundardAndTwentyNine.majorityElement(arr);
        System.out.println(res);
    }

    public List<Integer> majorityElement(int[] nums) {
        if(nums.length == 1) {
            List<Integer> result = new ArrayList<>(1);
            result.add(nums[0]);
            return result;
        }

        int threshold = nums.length/3;
        Map<Integer, Integer> countMap = new HashMap<>();

        Set<Integer> resSet = new HashSet<>();
        for(int i=0; i< nums.length; i++) {
             int tmp = countMap.getOrDefault(nums[i], 0);
             countMap.put(nums[i], ++tmp);

            if (tmp>threshold){
                resSet.add(nums[i]);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(Integer ele: resSet) {
            result.add(ele);
        }

        return result;
    }


}
