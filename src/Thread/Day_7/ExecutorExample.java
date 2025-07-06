package Thread.Day_7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExample {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Callable (returns value)
        Callable<Integer> integerCallable = () -> {
            Thread.sleep(5000);
            return 786;
        };

        Future<Integer> integerFuture = executorService.submit(integerCallable);

        System.out.println("Callable task submitted");
        // do other work

        System.out.println("Result: " + integerFuture.get()); // waits until it's completed

        // shutdown the executor
        executorService.shutdown();
    }
}
