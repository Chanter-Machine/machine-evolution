package algorithms.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Eighteen {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int[] nums2 = new int[]{0, 0, 0};
        int[] nums3 = new int[]{-2,-1,-1,1,1,2,2};
        int[] nums4 = new int[]{-1,2,2,-5,0,-1,4};
        int[] nums5 = new int[]{1,0,-1,0,-2,2};
        Eighteen eighteen = new Eighteen();
        System.out.println(eighteen.fourSum(nums5, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();

        HashMap<Integer, Integer> countMap =  new HashMap<>();
        HashMap<Integer, Integer> positionMap =  new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int pos = 0;
        for(int i=0;i<nums.length;i++) {
            if(countMap.containsKey(nums[i])) {
                countMap.put(nums[i], countMap.get(nums[i])+1);
            }else {
                countMap.put(nums[i], 1);
                positionMap.put(nums[i], pos++);
                list.add(nums[i]);
            }
        }

        for(int i=0;i< list.size();i++) {
            if(list.get(i) *4 == target && countMap.get(list.get(i))>=4) {
                Integer[] arr = new Integer[] {list.get(i),list.get(i),list.get(i),list.get(i)};
                List<Integer> result = Arrays.asList(arr);
                results.add(result);
            }

            for(int j=i+1; j<list.size();j++) {
                int tempSum = list.get(i) * 2 + list.get(j);
                int rest = target - tempSum;
                if(countMap.get(list.get(i)) >=2 && countMap.containsKey(rest) && positionMap.get(rest) >j) {
                    Integer[] arr = new Integer[] {list.get(i),list.get(i),list.get(j), rest};
                    results.add(new ArrayList<>(Arrays.asList(arr)));
                }

                tempSum = list.get(j) * 2 + list.get(i);
                rest = target - tempSum;
                if(countMap.get(list.get(j)) >=2 && countMap.containsKey(rest) && positionMap.get(rest) >j) {
                    Integer[] arr = new Integer[] {list.get(i),list.get(j),list.get(j), rest};
                    results.add(new ArrayList<>(Arrays.asList(arr)));
                }

                tempSum = list.get(j) * 3 + list.get(i);
                if(countMap.get(list.get(j)) >=3 && target==tempSum ) {
                    Integer[] arr = new Integer[] {list.get(i),list.get(j),list.get(j) ,list.get(j)};
                    results.add(new ArrayList<>(Arrays.asList(arr)));
                }

                tempSum = list.get(i) * 3 + list.get(j);
                if(countMap.get(list.get(i)) >=3 && target==tempSum ) {
                    Integer[] arr = new
                            Integer[] {list.get(i),list.get(i),list.get(i) ,list.get(j)};
                    results.add(new ArrayList<>(Arrays.asList(arr)));
                }

                tempSum = list.get(j) * 2 + list.get(i)* 2;

                if(countMap.get(list.get(j)) >=2 && countMap.get(list.get(i)) >=2 && tempSum == target) {
                    Integer[] arr = new Integer[] {list.get(i),list.get(i),list.get(j), list.get(j)};
                    results.add(new ArrayList<>(Arrays.asList(arr)));
                }

                tempSum = list.get(i) + list.get(j);
                rest  = target -tempSum;
                int left = j +1;
                int right = list.size() -1;
                while(left <= right ) {
                    if(list.get(left) + list.get(right) == rest) {
                        if (left == right ) {
                            if(countMap.get(list.get(left))>=2) {
                                Integer[] arr = new Integer[] {list.get(i),list.get(j),list.get(left), list.get(right)};
                                results.add(new ArrayList<>(Arrays.asList(arr)));
                            }
                        }else {
                            Integer[] arr = new Integer[] {list.get(i),list.get(j),list.get(left), list.get(right)};
                            results.add(new ArrayList<>(Arrays.asList(arr)));
                        }
                        left ++;
                        right --;

                    }else if (list.get(left) + list.get(right) > rest) {
                        right--;
                    }else if(list.get(left) + list.get(right) < rest ) {
                        left ++;
                    }
                }
            }
        }

        return results;
    }
}
