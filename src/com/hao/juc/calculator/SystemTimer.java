package com.hao.juc.calculator;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-14
 * Time: 上午11:35
 * To change this template use File | Settings | File Templates.
 */
public class SystemTimer {
    private final static ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private static final long tickUnit = Long.parseLong(System.getProperty("notify.systimer.tick", "50"));
    private static volatile long time = System.currentTimeMillis();

    private static class TimerTicker implements Runnable {
        public void run() {
            time = System.currentTimeMillis();
        }
    }

    public static long currentTimeMillis() {
        return time;
    }

    static {
        executor.scheduleAtFixedRate(new TimerTicker(), tickUnit, tickUnit, TimeUnit.MILLISECONDS);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                executor.shutdown();
            }
        });
    }

    public static void main(String[] args) {
        long begin1 = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            SystemTimer.currentTimeMillis();
        }

        long end1 = System.currentTimeMillis();
        System.out.println(end1 - begin1);

        System.out.println("==================================");

        long begin2 = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            System.currentTimeMillis();
        }

        long end2 = System.currentTimeMillis();
        System.out.println(end2 - begin2);


        //System.out.println(SystemTimer.tickUnit);
    }
}
