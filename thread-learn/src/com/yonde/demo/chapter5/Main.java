package com.yonde.demo.chapter5;

import java.util.concurrent.locks.LockSupport;

/**
 * Created By caiya
 * Date 2020/1/5 22:20
 * Description
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park!");
                // 挂起当前线程
                LockSupport.park();
                System.out.println("child thread end park!");
            }
        });
        thread.start();
        // 调用join这里会导致主线程也不继续执行，因为主线程在等待child线程执行结束，但是child线程已经被挂起
//        thread.join();

        Thread.sleep(1000);

        System.out.println("main thread begin unpark!");
        LockSupport.unpark(thread);
    }
}
