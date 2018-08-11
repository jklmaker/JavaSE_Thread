package com.bjut.thread.info;

/**
 * 线程优先级:(代表的是概率,没有先后顺序,不是绝对的)
 * 	MAX_PRIORITY	10
 * 	NORM_PRIORITY	5(默认)
 * 	MIN_PRIORITY	1
 * 
 * 	setPriority()
 * 	getPriority()
 * @author LENOVO
 *
 */
public class InfoDemo02 {

	public static void main(String[] args) throws InterruptedException {
		MyThread mt1 = new MyThread();
		Thread t1 = new Thread(mt1, "张三");
		
		MyThread mt2 = new MyThread();
		Thread t2 = new Thread(mt2, "李四");
		
		t1.setPriority(Thread.MIN_PRIORITY);	//设置优先级
		t2.setPriority(Thread.MAX_PRIORITY);	//设置优先级
		
		
		t1.start();
		t2.start();
		
		Thread.sleep(100);
		mt1.stop();
		mt2.stop();
	}
}
