package PrintUsingMultipleThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClient {

    /*Output :
    THREAD-1 : 1
    THREAD-2 : 2
    THREAD-3 : 3
    THREAD-1 : 4
    THREAD-2 : 5
    THREAD-3 : 6
    THREAD-1 : 7
    THREAD-2 : 8
    THREAD-3 : 9
    THREAD-1 : 10*/

    public static void main(String[] args) {
        //User input
        int numberOfThreads = 5;
        int totalNumbersToPrint = 20;
        PrintNumbers obj = new PrintNumbers(totalNumbersToPrint, numberOfThreads);
        for (int i = 1; i <= numberOfThreads; i++) {
            int threadPosition = i == numberOfThreads ? 0 : i;
            final String threadName = threadPosition == 0 ? "THREAD-" + numberOfThreads : "THREAD-" + threadPosition;
            Thread thread = new Thread(() -> {
                        obj.printNumbers(threadPosition);
            }, threadName);
            thread.start();
        }
    }






}
