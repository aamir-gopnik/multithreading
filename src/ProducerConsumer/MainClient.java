package ProducerConsumer;


import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class MainClient {

    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> eventsMsg = new ArrayBlockingQueue<>(10);
        Random random = new Random();

        Thread producer = new Thread(() -> {
            while(eventsMsg.size() < 10) {
                int num = random.nextInt() % 100;
                try {
                    eventsMsg.put(num);
                    System.out.println("Data added to queue -> " + eventsMsg.peek());
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while(!eventsMsg.isEmpty()) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Consuming Data from queue -> " + eventsMsg.poll());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}