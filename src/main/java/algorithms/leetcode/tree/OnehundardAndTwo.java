package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;

import java.util.*;

public class OnehundardAndTwo {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result  = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmpRes = new ArrayList<>();
            Queue<TreeNode> tmpQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (node.left != null) {
                    tmpQueue.add(node.left);
                }
                if (node.right != null) {
                    tmpQueue.add(node.right);
                }
                tmpRes.add(node.val);
            }
            queue = tmpQueue;
            result.add(tmpRes);
        }

        return result;
    }


}
