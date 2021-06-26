package algorithms.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;



public class FourtySeven {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int[] nums2 = new int[]{1,2,1};
        FourtySeven fourtySeven = new FourtySeven();
        System.out.println(fourtySeven.permuteUnique(nums2));

        List<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){

        }

    }

    List<List<Integer>> results;
    public List<List<Integer>> permuteUnique(int[] nums) {
        results = new ArrayList<>();
        if (nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        ArrayList<Integer> rest = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            rest.add(nums[i]);
        }
        calc(new ArrayList<>(), rest);
        return results;
    }

    public void calc(ArrayList<Integer> result, ArrayList<Integer> rest) {
        if(rest.size() == 0 ){
            results.add(new ArrayList<>(result));
            return;
        }
        for(int i=0;i<rest.size();i++) {
            if(i>0 && rest.get(i) == rest.get(i-1)){
                continue;
            }
            result.add(rest.get(i));
            int temp = rest.get(i);
            rest.remove(i);
            calc(result, rest);
            result.remove(result.size()-1);
            rest.add(i, temp);
        }
    }
}
