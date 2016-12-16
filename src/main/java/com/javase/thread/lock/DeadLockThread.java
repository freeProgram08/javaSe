package com.javase.thread.lock;

/**
 * 死锁例子
 */
public class DeadLockThread extends Thread{
    public static final Lock lock1=new Lock();
    public static final Lock lock2=new Lock();
    //业务流程状态标识
    public int flag;
    @Override
    public void run() {
        //1模式
        if(flag==1){
          synchronized (lock1){
              System.out.println(getName()+":卖货");
              synchronized (lock2){
                  System.out.println(getName()+":进货");
              }
          }
        }
        if(flag==2){
            synchronized (lock2){
                System.out.println(getName()+":进货");
                synchronized (lock1){
                    System.out.println(getName()+":卖货");
                }
            }
        }
    }

    public static void main(String[] args) {
        //走模式一
        //货物多走模式一
        DeadLockThread one = new DeadLockThread();
        one.setName("仓库一：");
        one.flag=1;
        //走模式二
        //货物少走模式二
        DeadLockThread two = new DeadLockThread();
        two.setName("仓库二：");
        two.flag=2;
        one.start();
        two.start();
        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
