package Thread.Day_6;

class TasksDataBox {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (available) { // wait, until data not consumed
            wait();
        }
        this.data = value;
        System.out.println("Produce: " + data);
        available = true;
        notifyAll(); // notify consumer like data has been produce
    }

    public synchronized void consume() throws InterruptedException {
        while (!available) { // wait, until data not produce
            wait();
        }
        System.out.println("consume: " + data);
        available = false;
        notifyAll(); // notify producer like data has been consumed
    }
}

public class TasksDay6 {

    public static void main(String[] args) {

        TasksDataBox tasksDataBox = new TasksDataBox();

        Thread produce = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    tasksDataBox.produce(i);
                    Thread.sleep(500);
                } catch (InterruptedException exception) {
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    tasksDataBox.consume();
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                }
            }
        });

        produce.start();
        consumer.start();
    }
}
