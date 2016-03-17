package com.wlt.DesignModel.Singleton;

/**
 * Created by somoOne on 2016/3/17.
 */
public class Singleton0 {
    private static Singleton0 instance=null;

    /* 私有构造方法，防止被实例化 */
    private Singleton0(){}

    //第一种
    public static synchronized Singleton0 getInstance0() {//没有synchronized关键字，这种方法在多线程环境不安全
        if(instance==null){
            instance=new Singleton0();
        }
        return instance;
    }
    //第二种
    public static  Singleton0 getInstance1() {
        if(instance==null){
            synchronized (instance){//加载此处若instance不为空，则不必加锁
                if(instance==null) {
                    instance = new Singleton0();//这一步稍微复杂，细节分为二步，创建实例对象和赋值，可能出现意外
                }
            }
        }
        return instance;
    }
    /*第三种单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，
    这个类的加载过程是线程互斥的。这样当我们第一次调用getInstance的时候，JVM能够帮我们保证
    instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕，这样我们就不用担心上
    面的问题。同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。
    */private static class SingletonFactory{
        private static Singleton0 instance=new Singleton0();
    }

    public static Singleton0 getInstance() {
        return SingletonFactory.instance;
    }

}
