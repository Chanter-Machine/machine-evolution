package algorithms.leetcode.math;

import algorithms.leetcode.two_pointer.OnehundardAndSixtyFive;
import jdk.internal.util.xml.impl.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class OnethoudandAndFourhundardAndFive {
    public static void main(String[] args) {
        int[] arr= new int[] {1,1,7};
        OnethoudandAndFourhundardAndFive onethoudandAndFourhundardAndFive = new OnethoudandAndFourhundardAndFive();
        onethoudandAndFourhundardAndFive.longestDiverseString(1,1,7);
    }

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        if(a>0) {
            heap.offer( new int[]{0, a});
        }
        if(b>0) {
            heap.offer(new int[]{1, b});
        }
        if(c>0) {
            heap.offer(new int[]{2, c});
        }
        while (!heap.isEmpty()) {
            int[] arr = heap.poll();
            int n = sb.length();
            if( n>=2 && sb.charAt(n-1) -'a'==arr[0] && sb.charAt(n-2)-'a'== arr[0]) {
                if(heap.isEmpty()) {
                    break;
                }
                int[] next = heap.poll();
                sb.append((char)(next[0] + 'a'));
                if(--next[1] != 0) {
                    heap.offer(next);
                }
                heap.add(arr);
            }else {
                sb.append((char)(arr[0]+'a'));
                if(--arr[1] > 0){
                    heap.add(arr);
                }
            }
        }
        return sb.toString();
    }
}
