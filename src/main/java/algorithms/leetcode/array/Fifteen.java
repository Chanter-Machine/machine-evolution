package algorithms.leetcode.array;

import java.util.*;

public class Fifteen {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums2 = new int[]{0, 0, 0};
        Fifteen fifteen = new Fifteen();
        System.out.println(fifteen.threeSum2(nums2));
    }

//    Bad solution, need to remove repeated elements
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        for (int j = 0; j < nums.length; j++) {
            System.out.print(nums[j] + "\t");
        }

        HashMap<Integer, Integer> map =  new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], i);
        }

        List<List<Integer>> result =  new ArrayList<>();
        for(int i=0;i<nums.length-1;i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            for(int j=i+1;j<nums.length;j++) {

                int tempSum = nums[i] + nums[j];
                int rest = 0 - tempSum;
                if(map.containsKey(rest)) {
                    int index = map.get(rest);
                    if (index != i && index != j && index>j) {
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(rest);
                        result.add(list);
                    }
                }
            }
        }

        return result;
    }
    public List<List<Integer>> threeSum2(int[] nums) {

        Arrays.sort(nums);

        HashMap<Integer, Integer> mapCount = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if (mapCount.containsKey(nums[i])) {
                mapCount.put(nums[i], mapCount.get(nums[i])+1);
            }else {
                mapCount.put(nums[i], 1);
            }
        }

        List<Integer> newArray = new ArrayList<>(mapCount.size());
        for(Map.Entry<Integer, Integer> entry : mapCount.entrySet()) {
            newArray.add(entry.getKey());
        }
        Collections.sort(newArray);

        List<List<Integer>> result =  new ArrayList<>();
        for(int i=0;i<newArray.size();i++) {
            if(mapCount.get(newArray.get(i))>=3 && newArray.get(i)*3 == 0) {
                result.add(Arrays.asList(newArray.get(i), newArray.get(i), newArray.get(i)));
            }
            for(int j=i+1; j<newArray.size();j++) {
                if(mapCount.get(newArray.get(i))>=2 && newArray.get(i)*2+ newArray.get(j)== 0) {
                    result.add(Arrays.asList(newArray.get(i), newArray.get(i), newArray.get(j)));
                }

                if(mapCount.get(newArray.get(j))>=2 && newArray.get(i) + newArray.get(j)*2 == 0) {
                    result.add(Arrays.asList(newArray.get(i), newArray.get(j), newArray.get(j)));
                }

                int tempSum = newArray.get(i) + newArray.get(j);
                int rest = 0 - tempSum;

                if (rest>newArray.get(j) && mapCount.containsKey(rest)) {
                    result.add(Arrays.asList(newArray.get(i), newArray.get(j), rest));
                }
            }


        }

        return result;
    }

//  TODO  Double pointers solution
    public List<List<Integer>> threeSum3(int[] nums) {

        return new ArrayList<>();
    }

}
