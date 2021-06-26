package algorithms.interview;

import java.util.*;

public class Test4 {


    public static void main(String[] args) {

    }

    //  Task 1
    public static void findSubStr(String str, int length) {
        int maxLen = 0;
        int minLen = length;

        HashSet<String> maxStrSet = new HashSet<String>();
        HashSet<String> minStrSet = new HashSet<String>();
        minStrSet.add(str.charAt(0) + "");
        char previous = ' ';
        //当前字符串长度
        int currentLen = 0;
        StringBuilder strTemp = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            char chCurrent = str.charAt(i);
//            当前和前一个字符相同 就++
            if (chCurrent == previous) {
                strTemp.append(chCurrent);
                currentLen++;
                if (currentLen > maxLen) {
                    maxStrSet = new HashSet<String>();
                    maxStrSet.add(strTemp.toString());
                } else if (currentLen == maxLen) {
                    maxStrSet.add(strTemp.toString());
                }
            } else {
                if (currentLen < minLen) {
                    minStrSet = new HashSet<String>();
                    minStrSet.add(strTemp.toString());
                } else if (chCurrent == minLen) {
                    minStrSet.add(strTemp.toString());
                }

                currentLen = 1;
                previous = chCurrent;
            }
//        return maxStrSet& minStrSet
        }


    }


    //task2 三数字之和等于100

}
