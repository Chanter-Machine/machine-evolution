package algorithms.leetcode.array;

import java.util.HashMap;
import java.util.Random;

public class FivehundardAndFiftyNine {
    public static void main(String[] args) {
        FivehundardAndFiftyNine fivehundardAndFiftyNine = new FivehundardAndFiftyNine(3, 1);
        int [] res = fivehundardAndFiftyNine.flip();
        System.out.println(res);
    }
    int m, n, size;
    HashMap<Integer, Integer> map;
    private static final Random RANDOM = new Random();
    public FivehundardAndFiftyNine(int m, int n) {
        this.m = m;
        this.n = n;
        this.size = m *n;
        map = new HashMap<>(size);
    }

    public int[] flip() {
        int x = RANDOM.nextInt(size--);
        int idx = map.getOrDefault(x, x);
        map.put(x, map.getOrDefault(size, size));
        int[] res =  new int[] {idx / n, idx % n};
        return res;

    }

    public void reset() {
        map.clear();
        size = this.m *this.n;
    }
}
