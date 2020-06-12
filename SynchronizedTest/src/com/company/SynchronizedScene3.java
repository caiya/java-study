package com.company;

/**
 * @author caiya
 * @date 2020/6/12 16:56
 * @description 两个线程同时访问两个对象的相同的static的synchronized方法
 * 静态同步方法，是类锁，所有实例是同一把锁，其他线程必然等待，顺序执行
 */
public class SynchronizedScene3 implements Runnable{
    static SynchronizedScene3 ss1 = new SynchronizedScene3();
    static SynchronizedScene3 ss2 = new SynchronizedScene3();

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

    public synchronized static void method(){
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
