package algorithms.leetcode.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        Random rd = new Random();
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = rd.nextInt(100)+1;
        }
        System.out.println(Arrays.toString(num));
        quickSort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }

    public static int[] quickSort(int[] arr, int i, int j) {
        if(i >= j) {
            return arr;
        }

        int value = arr[i];
        int left = i;
        int right = j;
        while(left < right) {
            while(arr[right] > value && left<right) {
                right --;
            }
            if(arr[right] < value) {
                arr[left] = arr[right];
                left ++;
            }
            while(arr[left] < value && left<right) {
                left ++;
            }
            if(arr[left] > value) {
                arr[right] = arr[left];
                right--;
            }
        }
        if (right == left) {
            arr[left] = value;
        }
        quickSort(arr, i, left-1);
        quickSort(arr, left+1, j);
        return arr;
    }
}
