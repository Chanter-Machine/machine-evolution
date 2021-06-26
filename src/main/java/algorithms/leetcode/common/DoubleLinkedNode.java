package algorithms.leetcode.common;

public class DoubleLinkedNode<T>{
    T val;
    public DoubleLinkedNode preNode;
    public DoubleLinkedNode nextNode;

    public DoubleLinkedNode(T val) {
        this.val = val;
    }

    public DoubleLinkedNode getPreNode() {
        return this.preNode;
    }

    public DoubleLinkedNode(T val, DoubleLinkedNode preNode, DoubleLinkedNode nextNode) {
        this.val = val;
        this.preNode = preNode;
        this.nextNode = nextNode;
    }

    public void print() {
        DoubleLinkedNode node = this;
        while (node != null) {
            System.out.println(node.val);
            node = node.nextNode;
        }
    }

    public static void staticPrint(DoubleLinkedNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.nextNode;
        }
    }
}
