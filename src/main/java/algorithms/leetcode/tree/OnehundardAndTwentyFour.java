package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;

import java.util.Map;

public class OnehundardAndTwentyFour {
    public static void main(String[] args) {

    }


    static int maxLeftPlusRight = 0;
    public int maxPathSum(TreeNode root) {
        maxLeftPlusRight = 0;
        return calc(root);
    }

    public int calc(TreeNode root) {

        if(root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            if (root.val < 0) {
                return 0;
            }
            return root.val;
        }

        int leftLength = 0;
        if (root.left != null) {
            leftLength = maxPathSum(root.left);
        }

        int rightLength = 0;
        if (root.right != null) {
            rightLength = maxPathSum(root.right);
        }

        if(rightLength + leftLength+ root.val > maxLeftPlusRight) {
            maxLeftPlusRight = leftLength + rightLength;
        }
        int maxLeftRight = Math.max(leftLength, rightLength);

        return (maxLeftRight + root.val) >0?maxLeftRight:0;
    }
}
