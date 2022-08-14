package algorithms.leetcode.linkList;

public class SixhundardAndTwentyTwo {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(81);
        myCircularQueue.enQueue(69);
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(192);
        myCircularQueue.enQueue(12);
        myCircularQueue.deQueue();
        myCircularQueue.Front();
    }
}

class MyCircularQueue {

    int[] arr;
    int head;
    int tail;
    int size;
    int cap;

    public MyCircularQueue(int k) {
        arr = new int[k];
        size = 0;
        head = 0;
        tail = 0;
        cap = k;
    }

    public boolean enQueue(int value) {
        if(size == cap) {
            return false;
        }
        if(size==0) {
            tail = head;
            arr[tail] = value;
            size++;
            return true;
        }

        if(tail==cap-1){
            tail = 0;
        }else {
            tail++;
        }
        arr[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if(size ==0) {
            return false;
        }
        if(head==cap-1) {
            head = 0;
        }else {
            head++;
        }
        size--;
        return true;
    }

    public int Front() {
        if(size == 0 ) {
            return -1;
        }
        return arr[head];
    }

    public int Rear() {
        if(size == 0 ) {
            return -1;
        }
        return arr[tail];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==cap;
    }
}