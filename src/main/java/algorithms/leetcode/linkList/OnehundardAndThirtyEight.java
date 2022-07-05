package algorithms.leetcode.linkList;

import java.util.HashMap;

public class OnehundardAndThirtyEight {

    HashMap<Node, Node> nodeMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }

        Node newNode = nodeMap.getOrDefault(head, null);
        if(newNode == null) {
            newNode = new Node(head.val);
            nodeMap.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }

        return newNode;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}

