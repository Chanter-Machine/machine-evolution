package collection;

import com.sun.corba.se.impl.oa.poa.AOMEntry;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class Example1 {
//    public static void main(String[] args) {
//        new Thread(()->{}, String.valueOf(1)).start();
//        Collections.synchronizedList(new ArrayList<>());
//        Vector<Integer> vector = new Vector<>();
//        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
//        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        ReentrantLock lock = new ReentrantLock();
//        CountDownLatch latch = new CountDownLatch(2);
//
//    }


        public static void main(String[] args) {

            String str1 = new StringBuilder("计算机").append("软件").toString();
            System.out.println(str1.intern() == str1);

            String str2 = new StringBuilder("ja").append("va").toString();
            System.out.println(str2.intern() == str2);

        }


    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+ "\t come in ");
        while(!atomicReference.compareAndSet(null, thread)) {
            Map hashMap = new HashMap();
        }
    }
}
