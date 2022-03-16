package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;

public class FourteenFourtyEight {

    int count = 0;
    public int goodNodes(TreeNode root) {
        calc(root, Integer.MIN_VALUE);
        return count;
    }

    private void calc(TreeNode node, int max) {
        if(node == null) {
            return;
        }
        if(node.val >= max) {
            count++;
            max = node.val;
        }
        calc(node.left, max);
        calc(node.right, max);
    }
}
