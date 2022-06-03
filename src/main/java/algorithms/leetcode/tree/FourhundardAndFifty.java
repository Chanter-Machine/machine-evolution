package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

public class FourhundardAndFifty {
    public static void main(String[] args) {
        FourhundardAndFifty fourhundardAndFifty = new FourhundardAndFifty();
        TreeNode root = new TreeNode(0);
        fourhundardAndFifty.deleteNode(root, 0);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return root;
        }

        if(root.val == key) {
            if( root.left == null&& root.right == null) {
                return null;
            }
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }
            merge(root.left, root.right);
            return root.right;
        }

        TreeNode parent = null;
        findTarget(root, parent, key, false);
        return root;
    }

    private boolean findTarget(TreeNode node, TreeNode parent, int key, boolean isRight) {
        if(node == null) {
            return false;
        }
        if(node.val != key) {
            return findTarget(node.left, node, key, false) || findTarget(node.right, node, key, true);
        }

        // node.val == key
        if(node.left == null && node.right == null) {
            if(isRight) {
                parent.right = null;
            }else {
                parent.left = null;
            }
            return true;
        }
        if(node.left == null) {

            if(isRight) {
                parent.right = node.right;
            }else {
                parent.left = node.right;
            }
            return true;
        }

        if(node.right == null) {
            if(isRight) {
                parent.right = node.left;
            }else {
                parent.left = node.left;
            }
            return true;
        }
        // node 左右节点都不为空 需要重新组合
        merge(node.left, node.right);
        if(isRight) {
            parent.right = node.right;
        }else {
            parent.left = node.right;
        }
        return true;
    }

    private void merge(TreeNode leftNode, TreeNode rightNode) {
        if(rightNode.left != null) {
            merge(leftNode, rightNode.left);
            return;
        }
        rightNode.left = leftNode;
    }
}
