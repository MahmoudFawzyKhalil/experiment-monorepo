package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class RaceCondition {
    volatile static int count;
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable =
                () -> IntStream.range(0, 500).forEach(i -> {
                    try {
                        lock.lock();
                        count++;
                    } finally {
                        lock.unlock();
                    }
                });

        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println(count);
    }
}