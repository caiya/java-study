package com.yonde.demo.chapter1;

import java.awt.*;
import java.security.PrivateKey;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class Main{

    private static volatile Object resourceA = new Object(); // 资源A
    private static volatile Object resourceB = new Object(); // 资源B

    private static final Lock lock = new ReentrantLock(); // 定义一个独占锁，默认为非公平锁

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // 设置线程A本地变量的值
                ThreadTest.set("threadA local variable!");
                ThreadTest.print("threadA");
                ThreadTest.remove();
                ThreadTest.print("threadA");
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadTest.set("threadB local variable!");
                ThreadTest.print("threadB");
                ThreadTest.remove();
                ThreadTest.print("threadB");
            }
        });

        threadA.start();
        threadB.start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (resourceA) {
//                    System.out.println("threadA get resourceA lock!");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    synchronized (resourceB) {
//                        System.out.println("threadA get resourceB lock!");
//                    }
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (resourceB) {
//                    System.out.println("threadB get resourceA lock!");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    synchronized (resourceA) {
//                        System.out.println("threadB get resourceB lock!");
//                    }
//                }
//            }
//        }).start();

//        Thread threadA = new Thread(() -> {
//            synchronized (resourceA) {
//                System.out.println("threadA get resourceA lock!");
//                synchronized (resourceB) {
//                    System.out.println("threadA get resourceB lock!");
//                    System.out.println("threadA release resourceA lock!");
//                    try {
//                        resourceA.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        Thread threadB = new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//                synchronized(resourceA) {
//                    System.out.println("threadB get resourceA lock!");
//                    synchronized(resourceB) {
//                        System.out.println("threadB get resourceB lock!");
//                        System.out.println("threadB release resourceA lock!");
//                        resourceA.wait();
//                    }
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        threadA.start();
//        threadB.start();
//
//        threadA.join();
//        threadB.join();
//
//        System.out.println("Main over!");


//        Thread threadA = new Thread(() -> {
////            synchronized (resourceA) {
////                System.out.println("threadA get resourceA lock!");
////                try {
////                    System.out.println("threadA begin wait!");
////                    resourceA.wait();
////                    System.out.println("threadA end wait!");
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////            }
////        });
////        Thread threadB = new Thread(() -> {
////            synchronized (resourceA) {
////                System.out.println("threadB get resourceA lock!");
////                try {
////                    System.out.println("threadB begin wait!");
////                    resourceA.wait();
////                    System.out.println("threadB end wait!");
////                }catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////            }
////        });
////        Thread threadC = new Thread(() -> {
////            synchronized (resourceA) {
////                System.out.println("threadC get resourceA lock!");
////                System.out.println("threadC begin notify!");
////                resourceA.notifyAll(); // 唤醒所有resourceA上的资源监视器锁，会导致A、B线程均被唤醒，最终导致主线程执行完毕并退出
//////                resourceA.notify();  // 随机唤醒一个线程，另一个线程还处于挂起状态，主线程不会退出
////                System.out.println("threadC end notify!");
////            }
////        });
////
////        threadA.start();
////        threadB.start();
////
////        Thread.sleep(1000);
////        threadC.start();
////
////        threadA.join();
////        threadB.join();
////        threadC.join();
////
////        System.out.println("Main function over!");

//        final Thread mainThread = Thread.currentThread();
//        Thread threadA = new Thread(() -> {
//            for (;;) {
//
//            }
//        });
//        Thread threadB = new Thread(() -> {
//            try {
//                // sleep 不会出让锁，只会让出cpu时间片，等待时间结束之后
//                Thread.sleep(1000);
//                System.out.println("threadB interrupt mainThread!");
//                mainThread.interrupt(); // 打断主线程
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        threadA.start();
//        threadB.start();
//
//        System.out.println("Main function invoked!");
//
//        threadA.join(); // 主线程等待A线程执行结束，如果期间某个线程C打断了主线程，则主线程会抛InterruptedException异常

//        Thread threadA = new Thread(() -> {
//            lock.lock();
//            try {
//                System.out.println("threadA is in sleep!");
//                Thread.sleep(1000);
//                System.out.println("threadA is in awake!");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        });
//
//        Thread threadB = new Thread(() -> {
//            lock.lock();
//            try {
//                System.out.println("threadB is in sleep!");
//                Thread.sleep(1000);
//                System.out.println("threadB is in awake!");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }finally {
//                lock.unlock();
//            }
//        });
//
//        threadA.start();
//        threadB.start();
//
////        Thread.currentThread().wait(); // 主线程不能挂起，否则会报错
//        new Thread(() -> { for (;;) {}}).start();
//
//    @Override
//    public void run() {
//        Stream.iterate(0, n -> n + 1).limit(5).forEach(n -> {
//            if (n % 5 == 0) {
//                System.out.println(Thread.currentThread() + " yield cpu...");
//                Thread.yield(); // 暂时出让cpu时间片，待下次线程调度时获取到cpu时间片后从该处继续运行
//                System.out.println(Thread.currentThread() + " yield cpu end...");
//            }
//        });
//        System.out.println(Thread.currentThread() + " is over...");
    }
}