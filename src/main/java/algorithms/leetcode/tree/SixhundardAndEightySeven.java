package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;
import sun.nio.cs.ext.MacHebrew;

public class SixhundardAndEightySeven {
    public static void main(String[] args) {
        TreeNode root = TreeNode.constructTree(new Integer[]{1,4,5,4,4,null,5});
        SixhundardAndEightySeven sixhundardAndEightySeven = new SixhundardAndEightySeven();
        sixhundardAndEightySeven.longestUnivaluePath(root);
    }

    public int longestUnivaluePath(TreeNode root) {
        calc(root, null);
        return max;
    }
    int max = 0;
// [1,4,5,4,4,null,5]
    public int calc(TreeNode node, TreeNode parent) {
        if(node == null){
            return 0;
        }

        int leftMax = calc(node.left, node);
        int rightMax = calc(node.right, node);
        if(node.left != null && node.right != null) {
            if(node.left.val == node.val && node.right.val==node.val) {
                max = Math.max(max, leftMax+ rightMax);
            }else if(node.left.val == node.val) {
                max = Math.max(max, leftMax);
            }else if(node.right.val == node.val) {
                max = Math.max(max, rightMax);
            }
        }else if(node.left != null && node.val == node.left.val) {
            max = Math.max(max, leftMax);
        }else if (node.right != null && node.val== node.right.val) {
            max = Math.max(max, rightMax);
        }

        if(parent == null) {
            return 0;
        }
        if(parent.val == node.val) {
            int tmp = 0;
            if(node.left != null && node.left.val ==node.val) {
                tmp = Math.max(tmp, leftMax);
            }
            if(node.right != null && node.right.val ==node.val) {
                tmp = Math.max(tmp, rightMax);
            }
            return tmp +1;
        }
        return 0;
    }
}
