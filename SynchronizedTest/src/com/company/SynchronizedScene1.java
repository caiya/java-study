package com.company;

/**
 * @author caiya
 * @date 2020/6/12 16:50
 * @description 两个线程同时访问一个对象的相同的synchronized方法
 */
public class SynchronizedScene1 implements Runnable{
    static SynchronizedScene1 ss = new SynchronizedScene1();

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(ss);
        Thread t2 = new Thread(ss);
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
        // this 相当月ss
        synchronized (this){
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
