package algorithms.practice.segment_tree;

public class SegmentTree {

    int[] arr;
    int[] tree;
    public static void main(String[] args) {

        int[] arr = new int[] {1,3,5,7,9,11};
        SegmentTree segmentTree = new SegmentTree(arr);

        segmentTree.buildTree(arr, 0, 0, arr.length-1);
        for (int i = 0; i < 15; i++) {
            System.out.println(i+" "+ segmentTree.tree[i]);
        }
        segmentTree.update(4,6);
        System.out.println("hehe");
        int res = segmentTree.query(0, segmentTree.arr.length-1, 0, 2,5);
        System.out.println(res);
    }

    public SegmentTree(int[] arr) {
        this.arr = arr;
        this.tree = new int[100];
        buildTree(this.arr, 0, 0, this.arr.length-1);
    }

    private void buildTree(int[]arr, int node, int start, int end) {
        if(start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildTree(arr, node * 2 + 1, start, mid);
        buildTree(arr, node * 2 + 2, mid+1, end);

        tree[node] = tree[node *2 + 1] + tree[node *2 + 2];
    }

    public void update(int index, int val) {
        updateTree(0, arr.length-1, 0, index, val);
    }

    private void updateTree(int start, int end, int node, int index, int val) {
        if(start == end) {
            tree[node] = val;
            arr[index] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if(index <=mid) {
            updateTree(start, mid, node*2+1, index, val);
        }else {
            updateTree(mid+1, end, node*2+2, index, val);
        }
        tree[node] = tree[node *2 + 1] + tree[node *2 + 2];
    }

    public int query(int start, int end, int node, int left, int right) {
        if(right< start || left> end) {
            return 0;
        }else if(start == end) {
            return tree[node];
        }else if(left<= start && right>= end){
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        int leftNode = node*2+1;
        int rightNode = node*2+2;
        int sumLeft = query(start, mid, leftNode, left, right);
        int sumRight = query(mid+1, end, rightNode, left, right);
        return sumLeft + sumRight;
    }
}
