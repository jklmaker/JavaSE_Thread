package com.bjut.thread.info;
/**
 * Thread.currentThread()	获取当前线程
 * setName()				设置名称
 * getName()				获取名称
 * isAlive()				判断状态
 * @author LENOVO
 *
 */
public class InfoDemo01 {

	public static void main(String[] args) throws InterruptedException {
		MyThread mt = new MyThread();
		Thread proxy = new Thread(mt);
		proxy.setName("李四");
		System.out.println(proxy.getName());
		System.out.println(Thread.currentThread().getName());	//输出main
		
		proxy.start();
		
		System.out.println("启动后的状态:"+proxy.isAlive());	//true
		Thread.sleep(100);
		mt.stop();
		Thread.sleep(100);
		System.out.println("停止后的状态:"+proxy.isAlive());	//false
	}
}
