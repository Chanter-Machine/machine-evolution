package algorithms.leetcode.interval_sum;

public class ThreehundardAndSeven {

    public static void main(String[] args) {
        NumArray1 numArray1 = new NumArray1(new int[]{-1});
        numArray1.update(0,1);
        numArray1.sumRange(0,0);
    }
}

class NumArray1 {
    int[] blockSum;
    int blockSize;
    int blocks;
    int[] nums;
    public NumArray1(int[] nums) {
        this.nums = nums;
        blockSize = (int)Math.sqrt(nums.length);
        blocks = nums.length / blockSize;
        if(nums.length % (int)Math.sqrt(nums.length) !=0) {
            blocks += 1;
        }
        blockSum = new int[blocks];

        for(int i=0; i< nums.length; i++) {
            blockSum[i/blockSize] += nums[i];
        }
    }

    public void update(int index, int val) {
        blockSum[index/blockSize] -= this.nums[index];
        blockSum[index/blockSize] += val;
        this.nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int leftBlock = left/blockSize;
        int rightBlock = right/blockSize;
        if(leftBlock == rightBlock) {
            int sum = 0;
            for(int i=left; i<=right; i++) {
                sum += this.nums[i];
            }
            return sum;
        }
        int sum1 = 0;
        for(int i=left; i<blockSize*(leftBlock+1); i++) {
            sum1 += nums[i];
        }
        int sum2 = 0;
        for(int i=leftBlock+1; i<rightBlock; i++) {
            sum2 += this.blockSum[i];
        }
        int sum3 = 0;
        for(int i=blockSize*rightBlock; i<= right; i++) {
            sum3 += this.nums[i];
        }
        return sum1+sum2+sum3;
    }
}
class NumArray2 {
    SegmentTree segmentTree;
    public NumArray2(int[] nums) {
        segmentTree = new SegmentTree(nums);
    }

    public void update(int index, int val) {
        segmentTree.update(index, val);
    }

    public int sumRange(int left, int right) {
        return segmentTree.query(0, segmentTree.arr.length-1, 0, left, right);
    }
}

class SegmentTree {

    int[] arr;
    int[] tree;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        this.tree = new int[arr.length * 4];
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
