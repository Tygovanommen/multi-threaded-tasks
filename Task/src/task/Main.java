package task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // The amount of tasks you want to perform
        int taskAmount = 10;
        // The amount of threads you want to use
        int threadCount = 1;

        System.out.println("Process started...\n");

        // Start timer
        long startTime = System.currentTimeMillis();

        ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < taskAmount; i++) {
            Task newTask = new Task();
            threadPool.submit(newTask);
            tasks.add(newTask);
        }
        threadPool.shutdown();

        // Wait till all threads are done processing
        if (threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
            // Stop timer
            long endTime = System.currentTimeMillis();

            int successCount = 0;
            for (Task task : tasks) {
                if (task.isSuccess()) {
                    successCount++;
                }
            }

            // Show result
            System.out.println("\n### SYSTEM RESULT ###");
            System.out.println("System took " + (endTime - startTime) + " milliseconds to process " + taskAmount + " tasks using " + threadCount + " thread(s).");
            System.out.println(successCount + " tasks where successful and " + (taskAmount - successCount) + " tasks failed.");
        }
    }
}