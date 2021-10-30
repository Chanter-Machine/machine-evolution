package algorithms.leetcode.binary_search;

import algorithms.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class FourHundardAndNightySix {

    public static void main(String[] args) {
//        int[] nums1 = new int[]{4,1,2};
//        int[] nums2 = new int[]{4,1,2};
        int[] nums1 = new int[]{2, 4};
        int[] nums2 = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> pos = new HashMap<>();
        TreeNode root = null;
        for(int i=0; i<nums2.length;i++) {
            if (root == null) {
                root = new TreeNode(nums2[i]);
            }else {
                GenerateBinarySearchTree(root, nums2[i]);

            }
            pos.put(nums2[i], i);
        }

        int[] res = new int[nums1.length];
        for(int i=0; i< nums1.length; i++) {

            int find = BinarySearch(root, nums1[i], i, pos);
            res[i] = find;
        }

        return res;
    }

    public static int BinarySearch(TreeNode node, int x, int pos, HashMap<Integer, Integer> posMap) {
        if (node == null) {
            return -1;
        }
        if(node.val<=x) {
            return BinarySearch(node.right, x, pos, posMap);
        }else {
            if (posMap.get(node.val) <= pos) {
                int pos1 = BinarySearch(node.left, x, pos, posMap);
                int pos2 = BinarySearch(node.right, x, pos, posMap);
                if (pos1 == -1 && pos2 ==-1 ){
                    return -1;
                }else if (pos1 == -1) {
                    return pos2;
                }else if (pos2 == -1) {
                    return pos -1;
                } else{
                    return Math.min(pos1, pos2);
                }

            }else {
                return node.val;
            }
        }
    }

    public static void GenerateBinarySearchTree(TreeNode node, int x) {

        if (node.val < x) {
            if (node.right != null) {
                GenerateBinarySearchTree(node.right, x);
                return;
            }
            node.right = new TreeNode(x);
        }else if (node.val >x){
            if (node.left != null) {
                GenerateBinarySearchTree(node.left, x);
                return;
            }
            node.left = new TreeNode(x);
        }
    }

    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];

        int pointer = 0;
        Stack<Integer> stack = new Stack<>();

        return res;
    }
}
