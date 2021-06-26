package algorithms.leetcode.BFS;

import algorithms.leetcode.common.TreeNode;

public class OneHundardAndOne {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,4,4,3};
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        OneHundardAndOne oneHundardAndOne = new OneHundardAndOne();
        System.out.println(oneHundardAndOne.isSymmetric(treeNode1));

    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return false;
        }

        return calc(root.left, root.right);
    }

    public boolean calc(TreeNode left, TreeNode right) {
        if((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        if(left == null && right == null) {
            return true;
        }
        if(left.val == right.val) {
            return calc(left.left, right.right) && calc(left.right, right.left);
        }else {
            return false;
        }
    }
}
