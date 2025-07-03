package Thread.Day_5;

class CountInSynchorizedBlock {
    int count = 0;

    void increment() {
        synchronized (this) {
            count++;
        }
    }
}

public class SynchronizedBlock {

    public static void main(String[] args) throws InterruptedException {

        // using Synchronized block/object
        CountInSynchorizedBlock countInSynchorizedBlock = new CountInSynchorizedBlock();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                countInSynchorizedBlock.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                countInSynchorizedBlock.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("The final count in Synchronized block: " + countInSynchorizedBlock.count);
    }
}
