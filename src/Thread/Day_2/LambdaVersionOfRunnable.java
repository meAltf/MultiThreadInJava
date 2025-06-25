package Thread.Day_2;

public class LambdaVersionOfRunnable {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Running with Lambda: " + Thread.currentThread().getName());
        });
    }
}
