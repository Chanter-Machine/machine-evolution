package algorithms.practice.sorting;

public class Quicksort implements ISort {

    @Override
    public void doSort(int[] arr) {

    }

    public void quickSort(int[]arr, int begin, int end){
        if(begin<end) {
            int key = arr[begin];
            int left = begin;
            int right = end;
            while (left<right) {
                while (left<right && arr[right]>key) {
                    right--;
                }
                if(left<right) {
                    arr[left] = arr[right];
                    left++;
                }
                while (left<right && arr[left]>key) {
                    left++;
                }
                if(left<right) {
                    arr[right] = arr[left];
                    right--;
                }
            }
            arr[left] = key;
            quickSort(arr, begin, left-1);
            quickSort(arr, left+1, end);
        }
    }
}
