package algorithms.leetcode.two_pointer;

import algorithms.leetcode.BFS.OneHundardAndOne;

public class OnehundardAndSixtyFive {
    public static void main(String[] args) {
        OnehundardAndSixtyFive onehundardAndSixtyFive = new OnehundardAndSixtyFive();
        int res = onehundardAndSixtyFive.compareVersion2("1.1", "1.1.1");
        System.out.println(res);
    }


    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int num1 = 0;
        int num2 = 0;
        for(int i=0; i< Math.max(v1.length, v2.length); i++) {
            String str1 = "";
            String str2 = "";
            if(i>=v1.length) {
                str1 = "0";
                str2 = v2[i];
            }else if(i>=v2.length) {
                str2 = "0";
                str1 = v1[i];
            }else {
                str1 = v1[i];
                str2 = v2[i];
            }
            num1 = num1*10+Integer.parseInt(str1) ;
            num2 = num2*10+Integer.parseInt(str2);
        }
        if(num1 > num2) {
            return 1;
        }else if(num1< num2) {
            return -1;
        }else {

            return 0;
        }
    }

    public int compareVersion2(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

}
