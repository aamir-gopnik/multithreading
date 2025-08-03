package ProducerConsumer;

import java.util.Queue;

public class Consumer {

    private final Queue<Integer> messageQueue;

    public Consumer(Queue<Integer> messageQueue) {
        this.messageQueue = messageQueue;
    }

    public void consumeMessage() {

        while (true) {
            synchronized (messageQueue) {
                while (messageQueue.isEmpty()) {
                    try {
                        messageQueue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Integer message = messageQueue.poll();
                System.out.println(Thread.currentThread().getName() + " received " + message);
                messageQueue.notifyAll();
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
