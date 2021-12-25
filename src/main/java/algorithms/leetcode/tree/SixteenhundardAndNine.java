package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SixteenhundardAndNine {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node10 = new TreeNode(10);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node12 = new TreeNode(12);
        TreeNode node8 = new TreeNode(8);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);

        node1.left = node10;
        node1.right = node4;
        node10.left = node3;
        node3.left = node12;
        node3.right = node8;
        node4.left = node7;
        node4.right = node9;
        node7.left = node6;
        node9.right = node2;
    }

    public boolean isEvenOddTree(TreeNode root) {
        if(root.val %2 !=1) {
            return false;
        }
        LinkedList<TreeNode> list = new LinkedList<>();

        list.add(root);
        boolean isIncre = true;
        int pre = Integer.MIN_VALUE;
        while (!list.isEmpty()) {
            LinkedList<TreeNode> tmp = new LinkedList<>();
            while (!list.isEmpty()) {
                TreeNode node = list.pollFirst();
                if(isIncre) {
                    if(node.val %2 !=1 || node.val <= pre) {
                        return false;
                    }

                }else {
                    if(node.val %2 != 0 || node.val>= pre) {
                        return false;
                    }
                }
                pre = node.val;

                if(node.left != null) {
                    tmp.add(node.left);
                }
                if(node.right != null) {
                    tmp.add(node.right);
                }
            }

            if(tmp.size() != 0) {
                list = tmp;
            }
            isIncre =!isIncre;
            if(isIncre) {
                pre = Integer.MIN_VALUE;
            }else {
                pre = Integer.MAX_VALUE;
            }
        }
        return true;
    }
}
