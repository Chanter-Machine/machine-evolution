package algorithms.leetcode.tree;

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

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) {
              val = x;
          }
    }

}

/**
 * 中序遍历
 */
