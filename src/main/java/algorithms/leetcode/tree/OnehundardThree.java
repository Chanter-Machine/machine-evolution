package algorithms.leetcode.tree;

import algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OnehundardThree {

    public static void main(String[] args) {
        OnehundardThree onehundardThree = new OnehundardThree();
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;

        System.out.println(onehundardThree.zigzagLevelOrder(treeNode3));
    }

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        results = new ArrayList<>();

        ArrayList<TreeNode> level = new ArrayList<>();
        if(root == null) {
            return results;
        }
        level.add(root);
        IterateByLevel(level, true);
        return results;
    }

    public void IterateByLevel(ArrayList<TreeNode> level, boolean direction) {
        if (level.size() == 0 ) {
            return;
        }

        int length = level.size();
        ArrayList<TreeNode> newLevel = new ArrayList<>();
        ArrayList<Integer> levelVal = new ArrayList<>();
        if(direction) {
            for(int i=0;i<length; i++) {
                levelVal.add(level.get(i).val);
            }
        }else {
            for(int i=length-1;i>=0; i--) {
                levelVal.add(level.get(i).val);
            }
        }
        for(int i=0;i<length;i++) {
            if(level.get(i).left != null) {
                newLevel.add(level.get(i).left);
            }
            if(level.get(i).right != null) {
                newLevel.add(level.get(i).right);
            }
        }
        if(levelVal.size()!=0) {
            results.add(levelVal);
        }
        if (newLevel.size()!=0) {
            IterateByLevel(newLevel, !direction);
        }
    }


//    use Deque is better
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        results = new ArrayList<>();

//       https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/er-cha-shu-de-ju-chi-xing-ceng-xu-bian-l-qsun/
        return results;
    }
}
