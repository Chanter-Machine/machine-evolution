package algorithms.leetcode.math;

import java.util.*;

public class TwoHundardAndTwentyNine {

    public static void main(String[] args) {
        TwoHundardAndTwentyNine twoHundardAndTwentyNine = new TwoHundardAndTwentyNine();

//        int[] arr = new int[]{2};
//        int[] arr = new int[]{1,1,1,3,3,2,2,2};
//        int[] arr = new int[]{3,2,3};
        int[] arr = new int[]{-1,-1,-1};
//        int[] arr = new int[]{4,1,2,3,4,4,3,2,1,4};
//        int[] arr = new int[]{2,3};
        List<Integer> res =  twoHundardAndTwentyNine.majorityElement2(arr);
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

    public List<Integer> majorityElement2(int[] nums) {

        int vote1 = 0;
        int val1 = -1;
        int vote2 = 0;
        int val2 = -1;

        for(int num: nums) {
            if(vote1>0 && val1 == num) {
                vote1++;
            }else if(vote2>0 && val2 ==num) {
                vote2 ++;
            }else if(vote1 == 0 ) {
                vote1++;
                val1 = num;
            }else if (vote2 == 0) {
                vote2++;
                val2 = num;
            }else {
                vote1 --;
                vote2 --;
            }
        }

        List<Integer> result = new ArrayList<>();
        int count1 = 0;
        int coutn2= 0;
        for(int ele: nums) {
            if(vote1>0  && val1 == ele) {
                count1 ++;
            }
            if (vote2>0 && val2 == ele) {
                coutn2 ++;
            }
        }

        if(count1 > nums.length/3) {
            result.add(val1);
        }
        if (coutn2 > nums.length/3) {
            result.add(val2);
        }

        return result;
    }

}
