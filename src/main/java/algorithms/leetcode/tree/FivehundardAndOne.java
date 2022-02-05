package algorithms.leetcode.tree;
import algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;

public class FivehundardAndOne {
    public static void main(String[] args) {
        Integer []arr = new Integer[]{6,2,8,0,4,7,9,null,null,2,6};
        TreeNode node = TreeNode.constructTree(arr);
        FivehundardAndOne fivehundardAndOne = new FivehundardAndOne();
        fivehundardAndOne.findMode(node);
    }

    Integer count, tmpCount;
    int base;
    ArrayList<Integer> list;
    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        count = 0;
        tmpCount = 0;
        dfs(root);
        int[] arr = new int[list.size()];
        int i=0;
        for(Integer num: list) {
            arr[i++] = num;
        }
        return arr;
    }



    private void dfs(TreeNode node) {
        if(node == null) {
            return ;
        }
        dfs(node.left);
        update(node.val);
        dfs(node.right);
    }

    private void update(int num) {
        if(num == base) {
            tmpCount++;
        }else {
            tmpCount = 1;
            base = num;
        }
        if(tmpCount == count) {
            list.add(base);
        }
        if(tmpCount>count) {
            list.clear();
            list.add(base);
            count = tmpCount;
        }
    }
}
