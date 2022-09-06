package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;
import algorithms.leetcode.string.Six;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SixhundardAndFiftyTwo {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1,2,3,4,null,2,4,null,null,4};
        TreeNode root = TreeNode.constructTree(arr);
        SixhundardAndFiftyTwo sixhundardAndFiftyTwo = new SixhundardAndFiftyTwo();
        sixhundardAndFiftyTwo.findDuplicateSubtrees(root);
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        resNodes = new LinkedList<>();
        calc(root);

        return resNodes;

    }

    Map<String, Integer> map;
    List<TreeNode> resNodes;

    private String  calc(TreeNode node) {

        if(node == null) {
            return " ";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val).append("_");
        sb.append(calc(node.left)).append(calc(node.right));
        String key = sb.toString();
        map.put(key, map.getOrDefault(key, 0)+1);
        if(map.get(key) == 2) {
            resNodes.add(node);
        }
        return key;
    }

}
