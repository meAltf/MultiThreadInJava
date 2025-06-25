package Thread.Day_1;

/** Using Runnable Interface **/
public class multiThreadingByRunnable {

    public static void main(String[] args) {

        // Task 1 : Numbers
        Runnable numberTask = () -> {
            for (int i = 1; i <= 4; i++) {
                System.out.println("Number: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException exception) {
                }
            }
        };

        // Task 2 : Letters
        Runnable letterTask = () -> {
            for (char c = 'A'; c <= 'D'; c++) {
                System.out.println("Letters: " + c);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException exception) {
                }
            }
        };

        // create threads
        Thread thread1 = new Thread(numberTask);
        Thread thread2 = new Thread(letterTask);

        // start threads
        thread1.start();
        thread2.start();
    }
}
