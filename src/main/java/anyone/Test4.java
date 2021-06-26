package anyone;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Test4 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Producer producer =  new Producer((ArrayList<Integer>) list);
        Consumer consumer = new Consumer((ArrayList) list);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }

    public static void calc() {
        Stack<Integer> stack = new Stack();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
    }

    public Integer minNum;
    //封装push



}


class Producer implements Runnable{

    List<Integer> list ;

    public Producer (ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                while (list.size() == 10) {
                    try{
                        list.wait();
                    }catch (Exception ex){

                    }
                }
                list.add(1);
                list.notifyAll();
            }
        }

    }
}

class Consumer implements Runnable{

    List<Integer> list ;
    public Consumer (ArrayList list) {
        this.list = list;
    }
    @Override
    public void run( ) {
        while (true) {
            synchronized (list) {
                while (list.size() == 0) {

                    try{
                        list.wait();
                    }catch (Exception ex){

                    }
                }
                list.remove(list.indexOf(0));
                list.notifyAll();
            }
        }

    }
}
