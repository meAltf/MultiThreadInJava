package Thread.Day_4;

public class DaemonDemo {
    public static void main(String[] args) {
        Thread daemon = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread running....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {}
            }
        });

        daemon.setDaemon(true); // must be set before start()
        daemon.start();

        //main thread going to stop after 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exception) {}
        System.out.println("Main thread ends...");
    }
}
