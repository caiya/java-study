package com.yonde.demo.chapter2;

import sun.misc.Unsafe;
import sun.reflect.Reflection;

import java.lang.reflect.Field;

/**
 * Created By caiya
 * Date 2020/1/3 22:18
 * Description
 */
public class TestUnsafe {
    // 获取Unsafe类的实例
    static Unsafe unsafe;
    // 记录变量state在TestUnsafe中的偏移
    static long stateOffset;
    // state变量
    private volatile long state = 0;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            throw new Error(e);
        }
    }

}
