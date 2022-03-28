package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class TwohundardAndThirtyNine {
    public static void main(String[] args) {

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        result = null;
        postTransverse(root,p, q);
        return result;

    }
    TreeNode result ;

    public int postTransverse(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) {
            return  0;
        }
        int sum =0;
        sum += postTransverse(node.left, p, q);


        sum += postTransverse(node.right, p,q);

        if(node == p || node == q) {
            sum += 1;
        }
        if(sum == 2) {
            result = node;
            return 0;
        }
        return sum;
    }
}
