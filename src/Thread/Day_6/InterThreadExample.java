package Thread.Day_6;

class DataBox {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (available) { // wait, if data not yet consumed
            wait();
        }
        this.data = value;
        System.out.println("Produced data: " + data);
        available = true;
        notify(); // notify consumer like data has been produced, please consume.
    }

    public synchronized void consume() throws InterruptedException {
        while (!available) { // wait, if data not yet produce
            wait();
        }
        System.out.println("Consumed data: " + data);
        available = false;
        notify(); // notify producer like data has been consumed, please produce new data
    }
}

public class InterThreadExample {

    public static void main(String[] args) {

        DataBox dataBox = new DataBox();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    dataBox.produce(i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    dataBox.consume();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
