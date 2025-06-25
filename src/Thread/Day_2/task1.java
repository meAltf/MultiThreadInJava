package Thread.Day_2;

import java.time.LocalTime;

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

/**
 * Task 2: Create a class that implements Runnable
 * It should print numbers from 1 to 10.
 * Run it using a new thread.
 */
class MyThreadTask2 implements Runnable{
    @Override
    public void run() {
        for(int i=1; i<=10; i++){
            System.out.print(i +" ");
        }
    }
}

/**
 Task 3: Use Lambda expression with Runnable
 Print current time 3 times in a thread using lambda + Thread.sleep(1000).
 */
// check directly main function for this task-3

public class task1 {
    public static void main(String[] args) {
        System.out.println("Thread from main:-- " + Thread.currentThread().getName());

        /* Task-1 */
        Thread threadTask1 = new MyThreadTask1();
        threadTask1.start();

        /* Task-2 */
        MyThreadTask2 threadTask2 = new MyThreadTask2();
        Thread createNewThreadTask2 = new Thread(threadTask2);
        createNewThreadTask2.start();

        /* Task-3 */
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Current Time : " + LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    throw new RuntimeException(exception);
                }
            }
        });
        thread.start();

    }
}
