package Thread.Day_2;

class MyThread extends Thread {
    public void run() {
        System.out.println("Running from the thread: " + Thread.currentThread().getName());
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        System.out.println("Running from main Thread: " + Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

/**
 * 1. start() launches a new thread, which then calls run() internally.
 * 2. Don't call run() directly—it won't start a new thread.
 */
