package algorithms.interview;

import java.util.ArrayList;

public class Test {

    ArrayList<Integer> arrayList = new ArrayList<>();

    boolean isLeafAP(Node root) {
        findLeaf(root);
        return isAP();
    }

    public boolean isAP(){
        //叶子节点只有一个或者两个的时候默认返回值为true
        if(arrayList.size()==1 || arrayList.size()==2){
            return true;
        }else{
            int progression = arrayList.get(1)-arrayList.get(0);
            for(int i=1;i<arrayList.size()-1;i++){
                if(arrayList.get(i+1) - arrayList.get(i) != progression){
                    return false;
                }
            }
            return true;
        }
    }

    public void findLeaf(Node node){
        if(node.left==null && node.right==null){
            arrayList.add(node.val);
        }else{
            if(node.left!=null){
                findLeaf(node.left);
            }
            if(node.right!=null){
                findLeaf(node.right);
            }
        }
    }

}
    class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }
}
