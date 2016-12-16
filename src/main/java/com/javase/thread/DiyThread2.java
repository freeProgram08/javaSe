package com.javase.thread;

/**
 * 注入方式实现线程
 */
public class DiyThread2 implements Runnable {
    public void run() {
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        //通过传入一个Runnable对象构建线程
        Thread thread=new Thread(new DiyThread2());
        thread.start();
    }
}
