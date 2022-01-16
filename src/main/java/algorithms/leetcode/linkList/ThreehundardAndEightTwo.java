package algorithms.leetcode.linkList;

import algorithms.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Random;

public class ThreehundardAndEightTwo {

    HashMap<Integer, Integer> map;
    Random random;
    public ThreehundardAndEightTwo(ListNode head) {

        map = new HashMap<>();
        int count = 0;
        while (head != null) {
            map.put(count, head.val);
            head = head.next;
            count++;
        }
        random = new Random();
    }

    public int getRandom() {
        return map.get(random.nextInt(map.size()));
    }
}
