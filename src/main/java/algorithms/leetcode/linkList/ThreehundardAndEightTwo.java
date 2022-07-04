package algorithms.leetcode.linkList;

import algorithms.leetcode.binary_search.Threehundard;
import algorithms.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Random;

public class ThreehundardAndEightTwo {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next  =node2;
        node2.next = node3;
        ThreehundardAndEightTwo threehundardAndEightTwo = new ThreehundardAndEightTwo(node1);
        for(int i=0; i<100; i++) {

        System.out.println(threehundardAndEightTwo.getRandom());
        }
    }

    ListNode head;
    Random  random;
    public ThreehundardAndEightTwo(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        ListNode node = head;
        int reserve = 0;
        int count = 1;
        while (node != null) {
            if(random.nextFloat() <= 1/(float)count) {
                reserve = node.val;
            }
            node = node.next;
            count++;
        }

        return reserve;

    }

    public int getRandom2() {
        int i = 1, ans = 0;
        for (ListNode node = head; node != null; node = node.next) {
            if (random.nextInt(i) == 0) { // 1/i 的概率选中（替换为答案）
                ans = node.val;
            }
            ++i;
        }
        return ans;
    }


}
