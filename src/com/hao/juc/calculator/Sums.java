package com.hao.juc.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 开启系统可用内核 +1个线程，分别执行1到1000000000之和，并将1000000000分5份执行。
 *
 * @author Administrator
 */
public class Sums {
    static class Sum implements Callable<Long> {
        private final long from;
        private final long to;

        Sum(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() {
            long acc = 0;
            for (long i = from; i <= to; i++) {
                acc = acc + i;
            }
            return acc;
        }
    }

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

        long beginTime = System.currentTimeMillis();

        List<Future<Long>> results = executor.invokeAll(Arrays.asList(
                new Sum(0, 200000000),
                new Sum(200000001, 400000000),
                new Sum(400000001, 600000000),
                new Sum(600000001, 800000000),
                new Sum(800000001, 1000000000)
        ));

        executor.shutdown();

        long sum = 0;
        for (Future<Long> result : results) {
            sum += result.get();
        }
        System.out.println(sum);

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
    }
}
