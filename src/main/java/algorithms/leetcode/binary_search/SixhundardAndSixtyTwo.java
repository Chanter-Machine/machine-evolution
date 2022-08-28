package algorithms.leetcode.binary_search;

import algorithms.leetcode.common.TreeNode;
import algorithms.leetcode.common.TreePrintUtil;

import java.util.HashMap;

public class SixhundardAndSixtyTwo {

    public static void main(String[] args) {
//        TreeNode root = TreeNode.constructTree(new Integer[]{1,3,2,5});
//        SixhundardAndSixtyTwo sixhundardAndSixtyTwo = new SixhundardAndSixtyTwo();
//        sixhundardAndSixtyTwo.widthOfBinaryTree(root);
        TreeNode root = TreeNode.constructTree(new Integer[]{1,1,1,1,null,1,null,1,null,1,null});
        TreePrintUtil.pirnt(root);

    }

    HashMap<Integer, Long[]> map;

    public int widthOfBinaryTree(TreeNode root) {
        map = new HashMap<>();
        map.put(1, new Long[]{1L, 1L});
        calc(root.left, 1, true, 2);
        calc(root.right, 1, false, 2);


        int max = 0;
        for(Long[] arr : map.values()){
            max = (int) Math.max(max, arr[1].equals(arr[0])?1 :arr[1]-arr[0]+1);
        }

        return max;
    }


    public void calc(TreeNode node, long parNum, boolean isleft, int layer) {
        if( node == null) {
            return;
        }

        Long[] layerBorder = map.getOrDefault(layer, null);
        if(layerBorder == null) {
            layerBorder = new Long[2];
        }

        long num = 0;
        if(isleft) {
            num = parNum*2-1;
        }else {
            num = parNum*2;
        }

        if(layerBorder[0] == null) {
            layerBorder[0] = num;
        }else {
            layerBorder[0] = Math.min(layerBorder[0], num);
        }

        if(layerBorder[1] == null) {
            layerBorder[1] = num;
        }else {
            layerBorder[1] = Math.max(layerBorder[1], num);
        }

        map.put(layer, layerBorder);
        calc(node.left, num, true, layer+1);
        calc(node.right, num, false, layer+1);
    }
}
