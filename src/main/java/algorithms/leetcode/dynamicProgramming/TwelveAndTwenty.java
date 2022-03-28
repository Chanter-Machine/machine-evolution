package algorithms.leetcode.dynamicProgramming;

public class TwelveAndTwenty {
    public static void main(String[] args) {
        TwelveAndTwenty twelveAndTwenty = new TwelveAndTwenty();
//        for (int i=1; i<1000; i++) {
//            int res = twelveAndTwenty.countVowelPermutation(i);
//            System.out.println(i + " : " +res);
//        }
//        System.out.println(twelveAndTwenty.mod);
//        int res = twelveAndTwenty.countVowelPermutation(5);
//
        System.out.println(10 ^ 9+7);
    }
    int mod = (int)1e9+7;
    public int countVowelPermutation(int n) {
        if(n == 1) {
            return 5;
        }

        int sum = 5;
        int a = 1;
        int e = 1;
        int i = 1;
        int o = 1;
        int u = 1;
        for(int j=1; j<n; j++) {
//            sum = a + e*2 + i*4 + o*2+ u;
            int tmpA = calcPlusMod(calcPlusMod(e,i), u);
            int tmpE =  calcPlusMod(a, i);
            int tmpI =calcPlusMod( e,o);
            int tmpO = i%mod;
            int tmpU = calcPlusMod(i,o);
            a = tmpA;
            e = tmpE;
            i = tmpI;
            o = tmpO;
            u = tmpU;
//            System.out.println((j+1)+" : "+a+" "+e+" "+i+" "+o+" "+u);
        }
        sum = calcPlusMod(calcPlusMod(calcPlusMod(a,e),calcPlusMod(i,o)),u);

        return sum;
    }

    public int calcPlusMod(int num1, int num2) {
        return (num1%mod + num2%mod)%mod;
    }

    public int calcMultiMod(int num1, int num2) {
        return (num1%mod * num2%mod)%mod;
    }

    public int countVowelPermutation2(int n) {
        if(n == 1) {
            return 5;
        }

        int sum = 5;
        int a = 1;
        int e = 1;
        int i = 1;
        int o = 1;
        int u = 1;
        for(int j=1; j<n; j++) {
            sum =  calcPlusMod(calcPlusMod(calcPlusMod(a, u), calcMultiMod(e,2)) , calcPlusMod(calcMultiMod(i,4), calcMultiMod(o,2)));
            int tmpA = calcPlusMod(e, calcPlusMod(i, u));
            int tmpE =  calcPlusMod(a, i);
            int tmpI = calcPlusMod(e, o);
            int tmpO = i;
            int tmpU = calcPlusMod(i, o);
            a = tmpA;
            e = tmpE;
            i = tmpI;
            o = tmpO;
            u = tmpU;
        }

        return sum;
    }
}
