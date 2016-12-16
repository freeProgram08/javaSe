package com.javase.thread;

/**
 * 使用继承创建自定义线程类
 */
public class DiyThread extends Thread {
    /*线程中的run方法就是写业务代码的地方*/
    @Override
    public void run() {
       for(int i=1;i<=100;i++){
           if(i%2!=0){
               System.out.println(getName()+":"+i);
           }
       }
    }

    public static void main(String[] args) {
        DiyThread thread1 = new DiyThread();
        thread1.setName("wangNo1:");
        DiyThread thread2 = new DiyThread();
        thread2.setName("wangNo2:");
/*        thread1.run();
        thread2.run();*/
        //在多线程环境中有同步，异步的说法
        //同步：线程之间有优先级，上一个线程完成的情况下，下一个线程才可以执行
        /*线程之间是有相互关系的，必须分步骤。*/
        //异步：线程之间没有相互关系，可以各做各的。
        thread1.start();
        try {
            thread1.join();//同步 main方法会在这里停顿
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
