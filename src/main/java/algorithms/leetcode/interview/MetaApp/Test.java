package algorithms.leetcode.interview.MetaApp;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        String a = "没人";
        String b = "比我";
        String c = "更懂";

        String f = new String("java");
        String d = "java";
        String s = a + b + c + d;
        System.out.print("CNN ");
        System.out.println(calc(10));
        System.out.print(method(0));
    }
    static void cnn() {
        System.out.print("CNN ");
    }

    private static Integer method(Integer i){
        try{
            if(i++ > 0)
                throw new IOException();
            return i++;
        }catch (IOException e){
            i++;
            return i++;
        }catch (Exception e){
            i++;
            return i++;
        }finally {
            return i++;
        }
    }

    public static  int calc(int n) {
        try {
            n += 1;
            if (n / 0 > 0) {
                n += 1;
            } else {
                n -= 10;
            }
            return n;
        } catch (Exception e) {
            n++;
        }
        n++;
        return n++;
    }
}
