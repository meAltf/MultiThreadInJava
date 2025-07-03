package Thread.Day_5;

class CounterInSynchronizedMethod {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}

public class SynchronizedMethod {

    public static void main(String[] args) throws InterruptedException {

        CounterInSynchronizedMethod counterInSynchronizedMethod = new CounterInSynchronizedMethod();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counterInSynchronizedMethod.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counterInSynchronizedMethod.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("The final count in synchronized method: " + counterInSynchronizedMethod.count);
    }
}
