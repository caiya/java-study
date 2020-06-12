package com.company;

/**
 * @author caiya
 * @date 2020/6/12 17:00
 * @description 两个线程访问同一对象的不同的synchronized方法
 * 同一实例拥有同一把锁，所以顺序执行（说明：锁的是this对象==同一把锁）
 */
public class SynchronizedScene5 implements Runnable{
    static SynchronizedScene5 ss1 = new SynchronizedScene5();

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
        // 模拟两个线程同时访问不同的synchronized方法
        if(Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else{
            method2();
        }
    }

    public synchronized void method1(){
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
