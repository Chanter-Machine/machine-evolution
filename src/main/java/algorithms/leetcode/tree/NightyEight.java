package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;

public class NightyEight {

    long min = Long.MIN_VALUE ;

    public boolean isValidBST(TreeNode root) {
        return calc(root);

    }

    public boolean calc(TreeNode node){

        if(node==null){
            return true;
        }

        if(!calc(node.left)){
            return false;
        }

        if(node.val<=min){
            return false;
        }

        min = node.val;


        return calc(node.right);
    }

}

/**
 * 中序遍历
 */
