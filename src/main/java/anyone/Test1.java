package anyone;

public class Test1 {
    public static void main(String[] args) {

    }

    public static void calc(Node head, int k) {


            Node pointer1 = null;
            Node pointer2 = null;
            pointer1 = pointer2 = head;

            for(int i=0;i<k;i++) {
                pointer2 = pointer2.next;
                if(pointer2 == null) {
                    break;
                }
            }
            reverse(pointer1, pointer2);


    }

    public static Node reverse(Node node1, Node node2) {
        Node preNode, currentNode, nextNode;
        preNode = null;
        currentNode = node1;
        nextNode = node1;
        while (currentNode != node2) {
            nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode =nextNode;
        }
        return preNode;
    }


    public static int binarySearch(int[] arr, int k) {
         int left = 0;
         int right = arr.length -1;
         int mid;

         while (left <= right) {
             mid = left + (right-left) /2;
             if(k < arr[mid]) {
                 right = mid - 1;
             }else if( k == arr[mid]) {
                 return mid;
             }else {
                 left = mid +1;
             }
         }
         return -1;
    }


}

class Node {
    int val;
    Node next;

    public Node(int x) {
        this.val = x;
    }
}