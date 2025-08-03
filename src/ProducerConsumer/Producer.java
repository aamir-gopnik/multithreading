package ProducerConsumer;

import java.util.Queue;
import java.util.Random;

class Producer {

    private final Queue<Integer> messageQueue;
    Random random = new Random();

    public Producer(Queue<Integer> queue){
        this.messageQueue = queue;
    }

    public void produceMessage() {
        while (true) {
            synchronized (messageQueue) {
                if (messageQueue.size() >= 10) {
                    try {
                        messageQueue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int num = random.nextInt(100) + 1;
                messageQueue.add(num);
                System.out.println(Thread.currentThread().getName() + " adding data to Queue " + num);
                messageQueue.notifyAll();
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}