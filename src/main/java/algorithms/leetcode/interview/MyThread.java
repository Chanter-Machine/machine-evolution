package algorithms.leetcode.interview;

public class MyThread implements Runnable {

    static int target = 1;

    @Override
    public void run() {
        boolean flag = true;
        while(target<=99){
            synchronized (MyThread.class){
                if(target<=99){
                    System.out.println(Thread.currentThread().toString()+target);
                    target++;
                }
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());
        Thread t3 = new Thread(new MyThread());

        t1.start();
        t2.start();
        t3.start();
    }
}
