package algorithms.leetcode.linkList;


public class OfferTwentyNine {
    public static void main(String[] args) {
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node1 = new Node(1);
        node3.next = node4;
        node4.next = node1;
        node1.next = node3;
        Node head = node3;
        OfferTwentyNine offerTwentyNine = new OfferTwentyNine();
        offerTwentyNine.insert(head,2);

//        Node node2 = new Node(3);
//        Node node3 = new Node(3);
//        Node node4 = new Node(3);
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node2;

//        offerTwentyNine.insert(node2,0);

    }

    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if(head == null) {
            newNode.next = newNode;

            return newNode;
        }
        if(head.next == head) {

            head.next = newNode;
            newNode.next = head;
            return head;
        }

        Node node = head;
        while (node.next != head) {
            if(node.val <= node.next.val) {
                if(insertVal< node.val || insertVal> node.next.val) {
                    node = node.next;
                    continue;
                }else {
                    break;
                }
            }else{
                if(insertVal<node.val && insertVal<node.next.val) {
                    break;
                }else if (insertVal> node.val) {
                    break;
                }
                node = node.next;
            }

        }
        newNode.next = node.next;
        node.next = newNode;
        return head;
    }
}

class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }

}