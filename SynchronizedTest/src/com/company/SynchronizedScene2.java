package com.company;

/**
 * @author caiya
 * @date 2020/6/12 16:54
 * @description 两个线程同时访问两个对象的相同的synchronized方法
 */
public class SynchronizedScene2 implements Runnable{
    static SynchronizedScene2 ss1 = new SynchronizedScene2();
    static SynchronizedScene2 ss2 = new SynchronizedScene2();

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(ss1);
        Thread t2 = new Thread(ss2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("run over");
    }

    @Override
    public void run(){
        method();
    }

    public void method(){
        // this 相当月ss1、ss2
        synchronized (this) {
            System.out.println("开始执行:" + Thread.currentThread().getName());
            try {
                // 模拟执行内容
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("执行结束:" + Thread.currentThread().getName());
        }
    }
}
