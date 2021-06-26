package algorithms.offer.singleton;

public class Task2 {

    public static Object obj = null;

    public static void main(String[] args) {
        if (obj == null) {
            synchronized (Object.class) {
                if(obj==null) {
                    obj = new Object();
                }
            }
        }
    }
}
