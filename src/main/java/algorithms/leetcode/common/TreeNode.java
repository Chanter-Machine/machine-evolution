package algorithms.leetcode.common;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
         this.right = right;
    }

    public TreeNode getLeftChild(){
        return this.left;
    }

    public TreeNode getRightChild(){
        return this.right;
    }

    /**
     * 生成一棵树
     * @param array
     * @return
     */
    public static TreeNode constructTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        int index = 0;
        int length = array.length;

        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        TreeNode currNode;
        while (index < length) {
            index++;
            if (index >= length) {
                return root;
            }
            currNode = nodeQueue.poll();
            Integer leftChild = array[index];
            if (leftChild != null) {
                currNode.left = new TreeNode(leftChild);
                nodeQueue.offer(currNode.left);
            }
            index++;
            if (index >= length) {
                return root;
            }
            Integer rightChild = array[index];
            if (rightChild != null) {
                currNode.right = new TreeNode(rightChild);
                nodeQueue.offer(currNode.right);
            }
        }

        return root;
    }


}
