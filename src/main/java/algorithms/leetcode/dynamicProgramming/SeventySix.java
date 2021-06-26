package algorithms.leetcode.dynamicProgramming;

import java.util.*;

/**
 * Not finished
 */

public class SeventySix {

    public static void main(String[] args) {
        SeventySix seventySix = new SeventySix();
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";

        String s2 = "a";
        String t2 = "a";

        String s3 = "aa";
        String t3 = "aa";
        Object o = new Object();

        System.out.println(seventySix.minWindow(s2, t2));
    }

    public String minWindow(String s, String t) {
        HashSet<Character> dict = getDict(t);
        HashMap<Character, Integer> reocrd = new HashMap<>(t.length());
        for(Character c: dict) {
            reocrd.put(c, -1);
        }

        char[] charArr = s.toCharArray();
        int left = -1;
        int right = -1;
        int minLen = Integer.MAX_VALUE;
        int fLeft =-1, fRight = -1;
        int rest = t.length();
        Queue<Integer> indexQueue = new LinkedList<>();

        for(int i=0;i<charArr.length;i++) {
            if(dict.contains(charArr[i])) {
                if(reocrd.get(charArr[i]) == -1) {
                    if(left == -1) {
                        left = i;
                    }
                    rest --;
                }else{
                    if(reocrd.get(charArr[i]) == indexQueue.peek()) {
                        indexQueue.poll();
                        left = indexQueue.peek();
                    }else {
                        Iterator<Integer> iterator = indexQueue.iterator();
                        while (iterator.hasNext()) {
                            if(iterator.next() == reocrd.get(charArr[i])){
                                iterator.remove();
                                break;
                            }
                        }
                    }

                }
                indexQueue.offer(i);
                reocrd.put(charArr[i], i);
                right = i;
                if(left!=-1 && right != -1 && right-left <minLen && rest==0) {
                    fLeft = left;
                    fRight = right;
                    minLen = fRight - fLeft;
                }
            }
        }

        if(fLeft != -1 && fRight != -1) {
            return s.substring(fLeft, fRight+1);
        }else {
            return "";
        }
    }

    public HashSet<Character> getDict(String t) {
        HashSet<Character> dict = new HashSet();
        char[] tArr = t.toCharArray();
        for(int i=0;i<tArr.length; i++){
            dict.add(tArr[i]);
        }
        return dict;
    }
}
