package algorithms.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class FivehundardAndNinety {

    List<Integer> res;
    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        iter(root);
        return res;
    }

    private void iter(Node node) {
        if(node == null) {
            return;
        }
        for(Node child : node.children) {
            iter(child);
        }
        res.add(node.val);
    }
    
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};