package algorithms.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FourtySix {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        FourtySix fourtySix = new FourtySix();
        System.out.println(fourtySix.permute(nums));
    }

    List<List<Integer>> results;
    public List<List<Integer>> permute(int[] nums) {
        results = new ArrayList<>();
        if (nums.length == 0) {
            return results;
        }
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
            result.add(rest.get(i));
            int temp = rest.get(i);
            rest.remove(i);
            calc(result, rest);
            result.remove(result.size()-1);
            rest.add(i, temp);
        }
    }
}
