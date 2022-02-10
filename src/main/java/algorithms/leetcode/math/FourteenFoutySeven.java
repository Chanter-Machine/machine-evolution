package algorithms.leetcode.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FourteenFoutySeven {
    public static void main(String[] args) {

    }

    public List<String> simplifiedFractions(int n) {
        List<String> result = new LinkedList<>();
        for(int i=2; i<=n; i++) {
            for(int j=1; j<i; j++) {
                if(gcd(j, i) ==1) {
                    result.add(j+"/"+i);
                }
            }
        }
        return result;
    }

    private int gcd(int a, int b) {
        return b!=0 ?gcd(b,a%b):a;
    }
}
