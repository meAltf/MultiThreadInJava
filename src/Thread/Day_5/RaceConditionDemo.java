package Thread.Day_5;

class Counter {
    int count = 0;

    void increment() {
        count++; //Not thread safe
    }
}

public class RaceConditionDemo {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        /** Everytime below line give unexpected count **/
        System.out.println("Final count: " + counter.count);
    }
}
