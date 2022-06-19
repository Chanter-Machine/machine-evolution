package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;
import algorithms.leetcode.two_pointer.Eleven;

import java.util.LinkedList;
import java.util.List;

public class ElevenTen {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1,2,null,4,3};
        TreeNode root = TreeNode.constructTree(arr);
        ElevenTen elevenTen = new ElevenTen();
        elevenTen.delNodes(root, new  int[] {2,3});
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> list = new LinkedList<>();
        list.add(root);

        for(int nodeVal : to_delete) {
            for(TreeNode node : list) {
                if(deleteNodeFromTree(node, list, null, false, nodeVal)) {
                    break;
                }
            }
        }
        return list;
    }


    private boolean deleteNodeFromTree(TreeNode node,List<TreeNode> forest, TreeNode parent, boolean isRight,  int toDel) {
        if(node == null) {
            return false;
        }
        if(node.val == toDel) {
            if(parent == null) {
                forest.remove(node);
                if(node.left != null) {
                    forest.add(node.left);
                }
                if(node.right != null) {
                    forest.add(node.right);
                }
                return true;
            }
            if(isRight) {
                parent.right = null;
            }else {
                parent.left = null;
            }
            if(node.left != null) {
                forest.add(node.left);
            }
            if(node.right != null) {
                forest.add(node.right);
            }

            return true;
        }
        return deleteNodeFromTree(node.left,forest, node, false, toDel) || deleteNodeFromTree(node.right,forest, node, true, toDel);
    }
}
