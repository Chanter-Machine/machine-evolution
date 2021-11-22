package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;

import java.util.*;

public class OnehundardAndThree {
    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n3.left = n9;
        n3.right = n20;
        n20.left = n15;
        n20.right = n7;

        OnehundardAndThree onehundardAndThree = new OnehundardAndThree();
        List<List<Integer>> res = onehundardAndThree.zigzagLevelOrder(n3);
        System.out.println(res);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        boolean direct = true;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmpRes = new ArrayList<>();
            Deque<TreeNode> tmpQueue = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode node;
                if (direct) {
                    node = queue.pollFirst();
                    if (node == null) {
                        continue;
                    }
                    if (node.left != null) {
                        tmpQueue.addLast(node.left);
                    }
                    if (node.right!= null) {
                        tmpQueue.add(node.right);
                    }
                }else {
                    node = queue.pollLast();
                    if (node == null) {
                        continue;
                    }
                    if (node.right!= null) {

                        tmpQueue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        tmpQueue.addFirst(node.left);
                    }


                }
                tmpRes.add(node.val);
            }
            queue = tmpQueue;
            direct = !direct;
            result.add(tmpRes);
        }

        return result;
    }
}
