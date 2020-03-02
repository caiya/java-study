package com.yonde.demo.chapter2;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created By caiya
 * Date 2020/1/3 22:35
 * Description
 */
public class Main {

    private static final ThreadLocal<String> LOCAL = new ThreadLocal<>();

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        TestUnsafe testUnsafe = new TestUnsafe();
        boolean success = TestUnsafe.unsafe.compareAndSwapLong(testUnsafe, TestUnsafe.stateOffset, 0, 1);
        Field field = testUnsafe.getClass().getDeclaredField("state");
        System.out.println("success: " + success);
        field.setAccessible(true);
        System.out.println((long) field.get(testUnsafe));

        LOCAL.set("test");

        ThreadLocalRandom random = ThreadLocalRandom.current();
        for(int i = 0; i < 10; ++i) {
            // 包含0不包含5
            System.out.println(random.nextInt(5));
        }

        System.out.println(LOCAL.get());
    }
}
