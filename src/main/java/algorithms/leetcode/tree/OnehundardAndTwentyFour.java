package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Map;

public class OnehundardAndTwentyFour {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;

        int res = new OnehundardAndTwentyFour().maxPathSum(n1);
        System.out.println(res);
    }


    static int maxLeftPlusRight;
    public int maxPathSum(TreeNode root) {
        maxLeftPlusRight = Integer.MIN_VALUE;
        calc(root);
        return maxLeftPlusRight;
    }

    public int calc(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int res = root.val;
        if(root.left == null && root.right ==  null) {
            maxLeftPlusRight = Math.max(res, maxLeftPlusRight);
        }else if(root.left != null && root.right !=  null){
            int tempres = 0;
            int maxLeftLen = calc(root.left);
            int maxRightLen = calc(root.right);
            if(maxLeftLen>0 ) {
                tempres += maxLeftLen;
            }
            if(maxRightLen > 0 ) {
                tempres += maxRightLen;
            }
            maxLeftPlusRight = Math.max(tempres+res, maxLeftPlusRight);
            int maxBranch = Math.max(maxLeftLen, maxRightLen);
            if(maxBranch >0) {
                res += maxBranch;
            }
        }else if (root.left != null ) {
            int maxLeftLen = calc(root.left);
            res = Math.max(root.val+ maxLeftLen, root.val);
            maxLeftPlusRight = Math.max(res, maxLeftPlusRight);
        }else {
            int maxRightLen = calc(root.right);
            res = Math.max(root.val+ maxRightLen, root.val);
            maxLeftPlusRight = Math.max(res, maxLeftPlusRight);
        }
        return res;

    }
}
