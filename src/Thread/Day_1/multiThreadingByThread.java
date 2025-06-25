package Thread.Day_1;

// Thread to print numbers
class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

// Thread to print letters
class LetterThread extends Thread {
    public void run() {
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.println("Letter: " + c);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class multiThreadingByThread {

    public static void main(String[] args) {
        NumberThread numThread = new NumberThread();
        LetterThread lettThread = new LetterThread();

        numThread.start();
        lettThread.start();
    }
}

/**
 🔍 Key Points:
 1. NumberThread and LetterThread both extend Thread.

 2. run() defines the task each thread performs.

 3. start() creates a new thread and calls run() internally.

 4. Threads execute in parallel, and output may be interleaved.
 */
