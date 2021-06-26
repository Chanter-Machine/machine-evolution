package algorithms.leetcode.interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Task491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<List<Integer>> element = new LinkedList<>();
        Map<String,Boolean> aMap = new HashMap<>();
        int max = nums[0];
        int min = nums[0];
        List<Integer> fistEleList = new LinkedList<>();
        element.add(fistEleList);
        List<Integer> first = new LinkedList<>();
        first.add(nums[0]);
        element.add(first);
        for(int i=1;i< nums.length;i++) {
            if(nums[i]>=max) {
                int size = element.size();
                for(int j=0;j<size;j++) {
                    List<Integer> temp = element.get(j);
                    temp.add(nums[i]);
                }
            }else if(nums[i]<min) {

            } else {

            }
        }
        return null;
    }
}
