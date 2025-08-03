package PrintUsingMultipleThreads;

public class MainClient {

    /*Output :
    THREAD-1 : 1
    THREAD-2 : 2
    THREAD-n : n
    THREAD-1 : n+1
    THREAD-2 : n+2
    ..............
    ..............*/

    public static void main(String[] args) {
        //User input that we can take
        int numberOfThreads = 5;
        int totalNumbersToPrint = 20;
        PrintNumbers obj = new PrintNumbers(totalNumbersToPrint, numberOfThreads);
        //Generating n  threads based on use input
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
