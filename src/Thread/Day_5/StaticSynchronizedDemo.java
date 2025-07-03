package Thread.Day_5;

class MyService {
    public static synchronized void printData(String name) {
        System.out.println(name + " - Started");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " - Ended");
    }
}

public class StaticSynchronizedDemo {

    public static void main(String[] args) {
        Runnable task1 = () -> {
            MyService.printData("Thread-A");
        };
        Runnable task2 = () -> {
            MyService.printData("Thread-B");
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
}
