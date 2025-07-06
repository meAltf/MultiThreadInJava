package Thread.Day_7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TasksDay7 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. Create a ThreadPool with fixed threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<Integer>> futureList = new ArrayList<>();

        // 2.  Callable tasks that return a number after sleeping
        Callable<Integer> integerCallable = () -> {
            int sleepTime = (int) (Math.random() * 1000);
            Thread.sleep(sleepTime);
            return sleepTime;
        };

        // 3. Submit the Callable tasks 5 times
        for (int i = 1; i <= 5; i++) {
            //Future<Integer> integerFuture = executorService.submit(integerCallable);
            futureList.add(executorService.submit(integerCallable));
        }

        // 4. print the result using future.get()
        //System.out.println("Result: " + integerFuture.get());
        for (int i = 1; i < futureList.size(); i++) {
            Integer result = futureList.get(i).get();
            System.out.println("Task " + i + " Completed in " + result + " ms");
        }

        // 5. shutdown the resource
        executorService.shutdown();
    }
}
