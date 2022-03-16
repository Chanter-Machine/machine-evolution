package algorithms.leetcode.linkList;

import java.util.HashMap;

public class OnehundardAndThirtyEight {
    HashMap<Node, Node> hMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        if(!hMap.containsKey(head)) {
            Node newHead = new Node(head.val);
            hMap.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }

        return hMap.get(head);
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

// Definition for a Node.

