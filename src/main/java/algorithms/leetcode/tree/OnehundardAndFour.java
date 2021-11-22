package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;

public class OnehundardAndFour {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftChildDepth = maxDepth(root.left);
        int rightChildDepth = maxDepth(root.right);
        return 1 + (Math.max(leftChildDepth, rightChildDepth));
    }
}
