package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;

public class TenTwentyTwo {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        StringBuilder sb = new StringBuilder();
        calc(root, sb);
        return sum;
    }

    private void calc(TreeNode node, StringBuilder sb) {
        if(node == null) {
            return ;
        }
        sb.append(node.val);
        if(node.right == null && node.left == null) {
            sum += Integer.parseInt(sb.toString(), 2);
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        calc(node.right, sb);
        calc(node.left, sb);
        sb.deleteCharAt(sb.length()-1);
    }

    private void calc2(TreeNode node, int num) {
        if(node == null) {
            return ;
        }
        num += (num<<1) + node.val;
        if(node.right == null && node.left == null) {
            sum += num;
            num >>=1;
            return;
        }
        calc2(node.right, num);
        calc2(node.left, num);
        num >>=1;
    }
}
