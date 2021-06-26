package algorithms.leetcode.backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirtyNine {
    public static void main(String[] args) {
        int[] candidates = new int[] {2,3,6,7};
        int target = 7;
        int[] candidates2 = new int[] {2,3,5};
        int target2 = 8;
        ThirtyNine thirtyNine = new ThirtyNine();
        System.out.println(thirtyNine.combinationSum(candidates2, target2));
    }

    List<List<Integer>> results;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        results = new ArrayList<>();
        if(candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        calc(new ArrayList<>(), 0, candidates, target, 0);
        return results;
    }

    public void calc(ArrayList<Integer> result, int current, int[]candidates, int target, int lastIndex) {
        if(current == target) {
            results.add(new ArrayList<>(result));
        }else if(current>target) {
            return;
        }
        for(int i=lastIndex;i<candidates.length;i++) {
            current += candidates[i];
            result.add(candidates[i]);
            calc(result, current, candidates, target, i);
            result.remove(result.size()-1);
            current -= candidates[i];
        }
    }
}
