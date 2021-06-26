package algorithms.leetcode.linkList;

import algorithms.leetcode.common.DoubleLinkedNode;

import java.util.HashMap;

public class OnehundardAndFourtySix {
    public static void main(String[] args) {

    }



}

// this one is not finished totally, but the rest part is not so hard to solve.
class LRUCache {

    HashMap<Integer, DoubleLinkedNode> map;
    DoubleLinkedNode<Integer> head, tail;
    Integer capacity;
    Integer size;

    public LRUCache(int capacity) {
        if(capacity<=0) {
            throw new RuntimeException();
        }
        map = new HashMap(capacity);
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = new DoubleLinkedNode(value);
        if(size ==0) {
            head = node;
            tail = node;
            map.put(key, node);

        }else if(size<capacity) {
            if(map.keySet().contains(key)) {
                DoubleLinkedNode tempCurrent = map.get(key);
                node.preNode = tempCurrent.preNode;
                node.nextNode = tempCurrent.nextNode;
                if(node.preNode != null) {
                    node.preNode.nextNode = node;
                }
                if(node.nextNode != null) {
                    node.nextNode.preNode = node;
                }
                if(tail == tempCurrent) {
                    tail = node;
                }
            }else{
                tail.nextNode = node;
                node.preNode = tail;
                tail = node;
            }
            map.put(key, node);
        }else if(size==capacity) {
            DoubleLinkedNode tempNext = head.nextNode;
            head.nextNode.preNode = null;
            head.nextNode = null;
            head = tempNext;
            //not finished
        }
    }
}

