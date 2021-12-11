package algorithms.leetcode.binary_search;


import algorithms.leetcode.common.ListNode;
import algorithms.leetcode.common.TreeNode;
import algorithms.leetcode.interview.MetaApp.A;

import java.util.ArrayList;

public class NighyNine {

    public static void main(String[] args) {
        NighyNine nighyNine = new NighyNine();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n3;
        n3.right = n2;
        nighyNine.recoverTree(n1);
    }

    public void recoverTree(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList();
        inorder(root, arr);
        int[] needSwap = findSwap(arr);
        recovery(root, 2, needSwap[0], needSwap[1]);
    }

    public void inorder(TreeNode node, ArrayList<Integer> arr) {
        if(node == null) {
            return;
        }
        if(node.left != null) {
            inorder(node.left, arr);
        }
        arr.add(node.val);
        if(node.right != null) {
            inorder(node.right, arr);
        }
    }

    public int[] findSwap(ArrayList<Integer> arr) {
        int n = arr.size();
        int index1 = -1, index2 = -1;
        for(int i=0; i<n-1; i++) {
            if(arr.get(i) > arr.get(i+1)){
                index2 = i+1;
                if(index1 == -1) {
                    index1 = i;
                }else {
                    break;
                }

            }
        }
        int x = arr.get(index1);
        int y = arr.get(index2);
        return new int[]{x, y};
    }

    public void recovery(TreeNode node, int count, int x, int y) {
        if(node != null) {
            if(node.val == x || node.val == y) {
                node.val = node.val == x?y:x;
                count --;
                if(count == 0) {
                    return;
                }
            }
        }
        if(node.left != null) {

            recovery(node.left, count, x, y);
        }
        if(node.right != null) {

            recovery(node.right, count, x, y);
        }
    }


}
