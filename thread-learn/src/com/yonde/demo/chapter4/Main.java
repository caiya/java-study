package com.yonde.demo.chapter4;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created By caiya
 * Date 2020/1/5 21:48
 * Description
 */
public class Main {
    private static volatile CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    static {
        copyOnWriteArrayList.add("hello");
        copyOnWriteArrayList.add("alibaba");
        copyOnWriteArrayList.add("welcome");
        copyOnWriteArrayList.add("to");
        copyOnWriteArrayList.add("hangzhou");
    }

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                copyOnWriteArrayList.set(1, "baba");
                copyOnWriteArrayList.remove(2);
                copyOnWriteArrayList.remove(3);
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                copyOnWriteArrayList.add("test");
                copyOnWriteArrayList.add("2222");
            }
        });
        Iterator<String> iterator = copyOnWriteArrayList.iterator();

        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
