package anyone;

import java.util.ArrayList;

public class Test2 {

    ArrayList<Integer> list = new ArrayList<>();
    public int printThree(TreeNode root, ArrayList list, int depth){

        list.add(root.val);
        depth ++;
        int depthToBot = 0;
        if(root.right != null) {
            root = root.right;
            printThree(root, list, depth);
        }else if(root.right == null) {
            return depth;
        }
        if(root.left != null) {

        }
        return 0;
    }

    public int calcDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 0;
    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}
