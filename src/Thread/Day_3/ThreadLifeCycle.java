package Thread.Day_3;

public class ThreadLifeCycle {

    public static void main(String[] args) {
        System.out.println("Start");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
            System.out.println("Interrupted");
        }
        System.out.println("End after 2 seconds");
    }
}
