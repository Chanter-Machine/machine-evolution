package algorithms.leetcode.binary_search;


import algorithms.leetcode.common.TreeNode;

public class NighyNine {

    public static void main(String[] args) {

    }

    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left != null && root.val < root.left.val) {
            int tmp = root.val;
            root.val = root.left.val;
            root.left.val = tmp;
            return;
        }
        if (root.right != null && root.val > root.right.val) {
            int tmp = root.val;
            root.val = root.right.val;
            root.right.val = tmp;
            return;
        }

        recoverTree(root.left);
        if(root.left != null && root.val < root.left.val) {
            int tmp = root.val;
            root.val = root.left.val;
            root.left.val = tmp;
            return;
        }
        recoverTree(root.right);
        if (root.right != null && root.val > root.right.val) {
            int tmp = root.val;
            root.val = root.right.val;
            root.right.val = tmp;
        }
    }

}
