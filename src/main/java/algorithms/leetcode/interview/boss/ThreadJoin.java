package algorithms.leetcode.interview.boss;

public class ThreadJoin {
    public static void main(String[] args) {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is thread 1");
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    System.out.println("This is thread 2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                    System.out.println("This is thread 3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread2.start();
        thread3.start();
        thread1.start();


    }
}
