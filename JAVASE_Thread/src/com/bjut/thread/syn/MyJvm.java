package com.bjut.thread.syn;

/**
 * 单例创建的方式
 * 1.懒汉式
 * 	构造器私有化
 * 	声明私有静态变量
 * 	对外提供访问变量的静态方法,确保对象存在
 * @author LENOVO
 *
 */
public class MyJvm {

	private static MyJvm instance;
	
	private MyJvm() {}
	
	public static MyJvm getInstance() {
		if(null == instance) {	//提高效率
			synchronized (MyJvm.class) {
				if(null == instance) {	//保证安全
					instance = new MyJvm();
				}
			}
		}
		return instance;
	} 
	
}

/**
 * 饿汉式
 * 	构造器私有化
 * 	声明私有静态变量,并同时创建该对象
 * 	对外提供访问变量的静态方法
 * @author LENOVO
 *
 */
class MyJvm2 {

	private static MyJvm2 instance = new MyJvm2();
	
	private MyJvm2() {}
	
	public static MyJvm2 getInstance() {
		return instance;
	} 
	
}

/**
 * 类在使用的时候才加载
 * 可以通过内部类延续加载时间
 * @author LENOVO
 *
 */
class MyJvm3 {

	private static class JvmHolder {
		private static MyJvm3 instance = new MyJvm3();
	}
	
	private MyJvm3() {}
	
	public static MyJvm3 getInstance() {
		return JvmHolder.instance;
	} 
	
}