package Thread.Day_2;

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Running in: " + Thread.currentThread().getName());
    }
}

public class RunnableExample {

    public static void main(String[] args) {
        System.out.println("Running in main--: " + Thread.currentThread().getName());

        Runnable runnableTask = new MyRunnable();
        Thread thread = new Thread(runnableTask);
        thread.start();

    }
}
/**
 * Runnable is better because Java supports only single inheritance, and it separates task (logic) from thread control.
 */