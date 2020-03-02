package com.yonde.demo.chapter1;

/**
 * Created By caiya
 * Date 2020/1/1 10:27
 * Description
 */
public class ThreadTest {
    // 线程本地变量
    private static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void print(String str) {
        // 打印当前线程本地变量str
        System.out.println(str + ":" + localVariable.get());
    }
    public static void set(String str) {
        localVariable.set(str);
    }

    public static void remove() {
        localVariable.remove();
    }

    // 用户线程-主线程
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // 设置线程A本地变量的值
                localVariable.set("threadA local variable!");
                print("threadA");
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadB local variable!");
                print("threadB");
            }
        });

        threadA.start();
        threadB.start();
    }
}
