package Thread.Day_3;

class JoinThreadTasksDay3 extends Thread {
    public void run() {
        System.out.println("Tasks Thread " + getName());
        for (int i = 0; i < 5; i++) {
            System.out.println("Loading...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {}
        }
    }
}

public class TasksDay3 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread " + Thread.currentThread().getName());
        JoinThreadTasksDay3 threadTasksDay3 = new JoinThreadTasksDay3();

        System.out.println("Thread status before start " + threadTasksDay3.isAlive());
        threadTasksDay3.start();
        System.out.println("Thread status after start " + threadTasksDay3.isAlive());

        threadTasksDay3.join();
        System.out.println("Thread status after join " + threadTasksDay3.isAlive());
    }
}
