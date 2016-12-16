package com.javase.thread.lock;

/**
 * Created by Administrator on 2016/12/16.
 */
public class DiyThread extends Thread {
    @Override
    public void run() {
        //验证锁的关键词
        //在验证过程中做的事情是不会被干扰的
        //以lock对象为凭证去做{}中的事情
        //抢锁事情是随机的，每次每个人抢锁的概率均等，
        //跟上一次谁抢到锁没关系

            for (int i = 1; i <= 1000; i++) {
                synchronized (PublicResource.lock){
                PublicResource.value++;
                }
            }


    }

    public static void main(String[] args) {
        DiyThread one = new DiyThread();
        DiyThread two = new DiyThread();
        DiyThread three = new DiyThread();
        DiyThread four = new DiyThread();
        DiyThread five = new DiyThread();
        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
        //之前的线程已经跑了一部分
        try {
            /*同步所有子线程，保证子线程所有方法执行完毕*/
            one.join();
            two.join();
            three.join();
            four.join();
            five.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*同步完，输出的结果才是最终结果*/
        System.out.println(PublicResource.value);
    }
}
