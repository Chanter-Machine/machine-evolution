package algorithms.leetcode.interview;

public class AlmostSort {

    public static void main(String args[]) {
        int[] array = { 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 11, 12, 14, 13, 12 };
        int[] array2 = { 1,2,3,4,5 };
        int[] insertSort = insertSort2(array2, 0);
        for (int i : insertSort) {
            System.out.print(i+" ");
        }
        System.out.println("");

    }

    //    O(kn)
    public static int[] insertSort(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                temp = array[i];
                for (int j = i; j >= 0; j--) {
                    if (j > 0 && array[j - 1] > temp) {
                        array[j] = array[j - 1];
                    } else {
                        array[j] = temp;
                        break;
                    }
                }
            }
        }
        return array;
    }

//    二分查找再插入 O(nlog(K))
    public static int[] insertSort2(int[] array, int k) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                temp = array[i];
                int left = i-k>0?i-k:0;
                int targetIndex = binarySearch(array, left, i, temp);
                for (int j = i; j >targetIndex; j--) {
                        array[j] = array[j - 1];
                }
                array[targetIndex] = temp;
            }
        }
        return array;
    }

    public static int binarySearch(int [] array, int left, int right, int tar){
//      解决left = right = 0;
        int mid = (left+right)/2;

        while(left<right){
            mid = (left+right)/2;

            if(array[mid]>tar){
                right = mid;
            }else if(array[mid] == tar){
                return mid;
            }else{
                left = mid+1;
            }
        }

        return array[mid]>tar?mid:mid+1;
    }

    public int[] minHeapSort(int[] array) {
        return array;
    }
}
