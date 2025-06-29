package Thread.Day_3;

class JoinThread extends Thread {
    public void run() {
        System.out.println("Thread started " + getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exception) {
        }

        System.out.println("Thread Ended " + getName());
    }
}

public class JoinDemo extends Thread {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread " + Thread.currentThread().getName());
        JoinThread joinThread = new JoinThread();
        joinThread.start();

        joinThread.join(); // main waits for joinThread to finish

        System.out.println("Main thread resumes after finishing of joinThread");

    }
}
