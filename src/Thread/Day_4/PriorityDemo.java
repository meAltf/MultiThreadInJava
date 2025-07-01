package Thread.Day_4;

public class PriorityDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() ->
                System.out.println("Thread-1 running!"));
        Thread thread2 = new Thread(() ->
                System.out.println("Thread-2 running!"));

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Thread-1 priority " + thread1.getPriority());
        System.out.println("Thread-2 priority " + thread2.getPriority());

        thread1.start();
        thread2.start();
    }
}
