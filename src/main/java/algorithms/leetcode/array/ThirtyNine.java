package algorithms.leetcode.array;

import java.util.*;

public class ThirtyNine implements Cloneable {
    public static void main(String[] args) {
        ThirtyNine thirtyNine =  new ThirtyNine();
//        int [] candidates = new int[]{2,3,6,7};
//        System.out.println(thirtyNine.combinationSum(candidates, 7));
        int [] candidates = new int[]{2,3,5};
        System.out.println(thirtyNine.combinationSum(candidates, 8));
    }

    List<List<Integer>> results;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        results = new ArrayList<>();
        Arrays.sort(candidates);
        ArrayList<Integer> result = new ArrayList<>();
        cal(candidates, target, result, 0);
        return results;
    }

    public void cal(int[] candidates, int rest, ArrayList<Integer> result, int lastNum) {
        if (rest == 0){
            ArrayList<Integer> newResult = (ArrayList<Integer>) result.clone();
            results.add(newResult);
            return;
        }
        if (rest<0) {
            return;
        }

        for(int i=0;i<candidates.length;i++) {
            if (candidates[i]<lastNum) {
                continue;
            }
            int newRest = rest - candidates[i];
            if (newRest<0) {
                break;
            }
            ArrayList<Integer> newResult = (ArrayList<Integer>) result.clone();
            newResult.add(candidates[i]);
            cal(candidates, newRest, newResult, candidates[i]);
        }
    }


}
