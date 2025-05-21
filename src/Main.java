
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SynchronizedCounter c  = new SynchronizedCounter();

        new Thread(() -> {
            Thread.currentThread().setName("First");
           c.incrementCounter(true);
        }).start();

        new Thread(() -> {
            Thread.currentThread().setName("Second");
            c.incrementCounter(false);
        }).start();
    }
}