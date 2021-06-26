package algorithms.leetcode.tree.unknown;

import algorithms.leetcode.common.TreeNode;

import java.util.Arrays;

public class OneHundardAndThree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length ==0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length>1){
            int rootIndexInOrder = -1;
            for(int i=0;i<inorder.length;i++){
                if(inorder[i] == root.val){
                    rootIndexInOrder = i;
                    break;
                }
            }
            int[] leftSubTreeInOrder= Arrays.copyOfRange(inorder, 0,rootIndexInOrder);
            int[] leftSubTreePreOrder;
            if(rootIndexInOrder>=1){
                leftSubTreePreOrder = Arrays.copyOfRange(preorder, 1, rootIndexInOrder+1);
            }else{
                leftSubTreePreOrder = new int[0];
            }

            int[] rightSubTreePreOrder ;
            int[] rightSubTreeInOrder;
            if(rootIndexInOrder<inorder.length-1){
                rightSubTreeInOrder = Arrays.copyOfRange(inorder, rootIndexInOrder+1, inorder.length);

                rightSubTreePreOrder = Arrays.copyOfRange(preorder, rootIndexInOrder+1, preorder.length);
            }else{
                rightSubTreeInOrder = new int[0];
                rightSubTreePreOrder = new int[0];
            }

            root.left = buildTree(leftSubTreePreOrder, leftSubTreeInOrder);
            root.right = buildTree(rightSubTreePreOrder, rightSubTreeInOrder);
        }

        return root;
    }



}
