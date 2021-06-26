package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;

public class FiveHundardAndSeventyTwo {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }

        if(compareTree(s, t)){
            return true;
        }else{
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }

    }

    public boolean compareTree(TreeNode s, TreeNode t){
        if(s==null && t==null){
            return true;
        }else if(s!=null && t!=null){
            if(s.val!=t.val){
                return false;
            }

            if(!compareTree(s.left, t.left)){
                return false;
            }

            return compareTree(s.right, t.right);
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(4);
        s.left = new TreeNode(1);
        s.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        FiveHundardAndSeventyTwo _572 = new FiveHundardAndSeventyTwo();
        boolean result = _572.isSubtree(s, t);
        System.out.println(result);
    }



}

