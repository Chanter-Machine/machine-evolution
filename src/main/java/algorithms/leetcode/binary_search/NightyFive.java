package algorithms.leetcode.binary_search;

import algorithms.leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class NightyFive {

    public static void main(String[] args) {

    }

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<>(null);
        }
        return GenerateBinarySearchTree(1, n);
    }

    public List<TreeNode> GenerateBinarySearchTree(int left, int right) {
        List<TreeNode> allTrees = new ArrayList<>();
        if(left > right) {
            allTrees.add(null);
            return allTrees;
        }

        for (int p = left; p<=right; p ++) {
            List<TreeNode> leftTrees = GenerateBinarySearchTree(left, p -1);
            List<TreeNode> rightTrees = GenerateBinarySearchTree(p +1, right);

            for(int i=0;i< leftTrees.size(); i++) {
                for(int j=0; j<rightTrees.size(); j++) {
                    TreeNode node = new TreeNode(p);
                    node.left = leftTrees.get(i);
                    node.right = rightTrees.get(j);
                    allTrees.add(node);
                }
            }

        }


        return allTrees;

    }


}
