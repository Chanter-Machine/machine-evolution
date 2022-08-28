package algorithms.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Fourty {

    public static void main(String[] args) {
        int[] candidate = new int[] {10,1,2,7,6,1,5};
        int target = 8;

        Fourty fourty = new Fourty();
        List<List<Integer>> tmp = fourty.combinationSum2(candidate, target);
        System.out.println(tmp.toString());
    }

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        backtracking(candidates, target, new boolean[candidates.length], new ArrayList<>(), 0);

        return res;
    }

    public void backtracking(int[] candidates, int target, boolean[] used, List<Integer> list, int lastIndex){
        if(target == 0) {
            List<Integer> newList = new ArrayList<>(list.size());
            for(Integer num : list) {
                newList.add(num);
            }
//            Collections.copy(newList, list);
            res.add(newList);
        }

        for(int i=lastIndex; i<candidates.length; i++) {
            if(used[i]) {
                continue;
            }
            if(i>lastIndex && candidates[i]==candidates[i-1]) {
                continue;
            }

            if((target - candidates[i]) >= 0) {
                used[i] = true;
                list.add(candidates[i]);
                backtracking(candidates, target-candidates[i], used, list, i+1);
                // backtracking
                used[i] = false;
                list.remove(list.size()-1);
            }
        }

    }
}
