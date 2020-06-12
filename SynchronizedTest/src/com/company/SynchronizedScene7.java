package com.company;

/**
 * @author caiya
 * @date 2020/6/12 17:16
 * @description 方法抛出异常后，会释放锁吗
 * 会自动释放锁，这里区别Lock，Lock需要显示的释放锁
 */
public class SynchronizedScene7 implements Runnable{
    static SynchronizedScene7 ss1 = new SynchronizedScene7();

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
        method1();
    }

    public synchronized void method1(){
        System.out.println("method1开始执行:" + Thread.currentThread().getName());
        try {
            // 模拟执行内容
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 模拟异常
        throw new RuntimeException();
        //System.out.println("method1执行结束:" + Thread.currentThread().getName());
    }
}

/*
一把锁只能同时被一个线程获取，没有拿到锁的线程必须等待（对应1、5的情景）

每个实例都对应有自己的一把锁，不同的实例之间互不影响；例外：锁对象是*.class以及synchronized被static修饰的时候，所有对象共用同一把锁（对应2、3、4、6情景）

无论是方法正常执行完毕还是方法抛出异常，都会释放锁（对应7情景）
*/
