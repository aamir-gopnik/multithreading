package SynchronizedCounter;

public class SynchronizedCounter {

    //private static int counter = 1;
    //private static AtomicInteger counter = new AtomicInteger(0);
    private int counter = 1;
    private final int limit = 10;
    private boolean firstThreadTurn = true;

    /*public synchronized void incrementCounter() {
        while(counter.get() < 50) {
            System.out.print("Thread -> " + Thread.currentThread().getName() + " ");
            System.out.println("Value of Counter -> " + counter.incrementAndGet());
        }
    }*/

    public synchronized void incrementCounter(boolean isFirstThread) {
        while (counter <= limit) {
            while (firstThreadTurn != isFirstThread) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore interrupt status
                    return;
                }
            }

            System.out.println(Thread.currentThread().getName() + " : " + counter++);
            firstThreadTurn = !firstThreadTurn;
            notifyAll(); // Wake up the other thread
        }
    }
}
