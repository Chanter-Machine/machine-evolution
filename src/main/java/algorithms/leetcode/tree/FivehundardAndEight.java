package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;
import algorithms.leetcode.interview.MetaApp.A;

import java.util.*;

public class FivehundardAndEight {
    public static void main(String[] args) {
        FivehundardAndEight fivehundardAndEight = new FivehundardAndEight();
        Integer[] arr = new Integer[]{5,2,-3};
        TreeNode root = TreeNode.constructTree(arr);
        fivehundardAndEight.findFrequentTreeSum(root);
    }

    public int[] findFrequentTreeSum(TreeNode root) {

        HashMap<Integer,Integer> map = new HashMap<>();

        iterTree(root, map);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        ArrayList<Integer> arr = new ArrayList<>();
        int maxCount = list.get(0).getValue();
        for(Map.Entry<Integer, Integer> entry : list) {
            if(entry.getValue() == maxCount) {
                arr.add(entry.getKey());
                continue;
            }
            break;
        }
        int[] res = new int[arr.size()];
        for(int i=0; i< arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }

    private int iterTree(TreeNode node, HashMap<Integer, Integer> map) {
        if(node == null) {
            return 0;
        }
        int sum = node.val + iterTree(node.left, map)+ iterTree(node.right, map);
        int count = map.getOrDefault(sum, 0);
        map.put(sum, count+1);
        return sum;
    }
}
