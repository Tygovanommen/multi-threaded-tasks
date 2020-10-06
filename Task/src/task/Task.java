package task;

import java.util.Random;

public class Task implements Runnable {

    private boolean isSuccess = false;

    @Override
    public void run() {
        try {
            // Do some task
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ": completed task.");
            this.isSuccess = new Random().nextBoolean();;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }
}