package Thread.Day_3;

public class isAliveDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {}
            System.out.println("Thread Done!");
        });

        System.out.println("Before start: Thread status- " + thread.isAlive());
        thread.start();

        System.out.println("After start: Thread status- " + thread.isAlive());
        thread.join();
        System.out.println("After join: Thread status- " + thread.isAlive());
    }
}
