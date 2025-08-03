package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
public class MainClient {

    public static void main(String[] args) {

        Queue<Integer> eventsMsgQueue = new LinkedList<>();
        Producer p1 = new Producer(eventsMsgQueue);
        Consumer c1 = new Consumer(eventsMsgQueue);
        Consumer c2 = new Consumer(eventsMsgQueue);
        Runnable r1 = p1::produceMessage;
        Runnable r2 = c1::consumeMessage;
        Runnable r3 = c2::consumeMessage;

        new Thread(r1, "Producer").start();
        new Thread(r2, "Consumer-1").start();
        new Thread(r3, "Consumer-2").start();
    }
}