package com.yonde.demo.chapter3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;
import java.util.stream.Stream;

/**
 * Created By caiya
 * Date 2020/1/5 19:20
 * Description
 */
public class Main {
    private static final Integer[] dataSourceOne = new Integer[] {0, 1, 3, 4, 0, 7, 9, 10};
    private static final Integer[] dataSourceTwo = new Integer[] {4, 2, 0, 4, 9, 7, 0, 0};

    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

    private static final LongAdder LONG_ADDER = new LongAdder();

    private static final LongAccumulator LONG_ACCUMULATOR = new LongAccumulator(new LongBinaryOperator() {
        @Override
        public long applyAsLong(long left, long right) {
            return left + right;
        }
    }, 6);

    public static void main(String[] args) throws InterruptedException {
        // 使用多线程统计两个数组中0的个数
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                Stream.of(dataSourceOne).forEach(s -> {
                    if (s.equals(0)) {
                        ATOMIC_INTEGER.incrementAndGet();
                    }
                    LONG_ADDER.add(s);
                    LONG_ACCUMULATOR.accumulate(s);
                });
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                Stream.of(dataSourceTwo).forEach(s -> {
                    if (s.equals(0)) {
                        ATOMIC_INTEGER.incrementAndGet();
                    }
                    LONG_ADDER.add(s);
                    LONG_ACCUMULATOR.accumulate(s);
                });
            }
        });
        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("累计0的个数为：" + ATOMIC_INTEGER.get() + " " + LONG_ADDER.intValue() + " " + LONG_ACCUMULATOR.intValue());
    }
}
