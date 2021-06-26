package algorithms.leetcode.interview.MetaApp;

public class A {

    class Inner {
        public String  v1 = "Fake News";
        public String v2 = "Go ahead";

        public Inner() {

        }
    }

    private static String GetVal() {
        try {
            Inner inner  = A.Inner.class.newInstance();
            return inner.v1;
        } catch (Exception e) {
            try {
                return Inner.class.getDeclaredConstructor(A.class).newInstance((A)null).v2;
            } catch (Exception ee) {
                ee.printStackTrace();
                return "Fake News, Go ahead";
            }
        }
    }
    public static void main(String[] args) {

        System.out.println(GetVal());
    }
}