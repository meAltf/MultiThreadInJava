package Thread.Day_2;

/**
 * Task 1: Create a class that extends Thread
 * It should print "👋 Hello from [thread name]" five times with a 1-second pause.
 */
class MyThreadTask1 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class task1 {
    public static void main(String[] args) {
        System.out.println("Thread from main:-- " + Thread.currentThread().getName());

        Thread threadTask1 = new MyThreadTask1();
        threadTask1.start();
    }
}
