package com.javase.thread.lock;

/**
 * Created by Administrator on 2016/12/16.
 */
public class PublicResource {
    //锁的概念：就是开门的钥匙
    /*或执行指令的权限*/
    /*锁必须是final，且必须是对象类型*/
    public static final Lock lock=new Lock();
    public static Integer value=0;
}
