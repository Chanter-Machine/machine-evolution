package algorithms.leetcode.array;

import algorithms.leetcode.interview.MetaApp.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Twelvehundard {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> res = new LinkedList<>();
        int len = arr.length;
        int diff = Integer.MAX_VALUE;
        for(int i=0; i<len-1; i++) {
            if(arr[i+1] - arr[i] < diff) {
                diff = arr[i+1] - arr[i];
                res = new LinkedList<>();
                ArrayList<Integer> tuple = new ArrayList<>(2);
                tuple.add(arr[i]);
                tuple.add(arr[i+1]);
                res.add(tuple);
            }else if(arr[i+1] - arr[i] == diff) {
                ArrayList<Integer> tuple = new ArrayList<>(2);
                tuple.add(arr[i]);
                tuple.add(arr[i+1]);
                res.add(tuple);
            }
        }

        return res;
    }
}
