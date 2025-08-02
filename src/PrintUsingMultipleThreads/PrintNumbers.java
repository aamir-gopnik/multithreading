package PrintUsingMultipleThreads;

public class PrintNumbers {

    private final int numbersToPrint;
    private final int threadsToUse;
    private static int counter = 1;

    public PrintNumbers(int numberUpperLimit, int threadsToUse) {
        this.numbersToPrint = numberUpperLimit;
        this.threadsToUse =  threadsToUse;
    }

    public void printNumbers(int threadPosition) {
        while(/*counter < MAX*/true)
        {
            synchronized (this) {
                while (counter % threadsToUse != threadPosition){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (counter > numbersToPrint) {
                    notifyAll();
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " : " + counter++);
                notifyAll();
            }
        }
    }
}
