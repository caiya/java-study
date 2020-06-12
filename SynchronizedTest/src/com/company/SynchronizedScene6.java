package com.company;

/**
 * @author caiya
 * @date 2020/6/12 17:04
 * @description 两个线程同时访问同一对象的static的synchronized方法与非static的synchronized方法
 * static同步方法是类锁，非static是对象锁，原理上是不同的锁，所以不受影响，并行执行
 */
public class SynchronizedScene6 implements Runnable{
    static SynchronizedScene6 ss1 = new SynchronizedScene6();

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(ss1);
        Thread t2 = new Thread(ss1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("run over");
    }

    @Override
    public void run(){
        // 模拟两个线程同时访问static的synchronized方法与非static的synchronized方法
        if(Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else{
            method2();
        }
    }

    public static synchronized void method1(){
        System.out.println("method1开始执行:" + Thread.currentThread().getName());
        try {
            // 模拟执行内容
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("method1执行结束:" + Thread.currentThread().getName());
    }

    public synchronized void method2(){
        System.out.println("method2开始执行:" + Thread.currentThread().getName());
        try {
            // 模拟执行内容
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("method2执行结束:" + Thread.currentThread().getName());
    }
}
