package com.bjut.thread.status;

/**
 * sleep模拟网络延时
 * @author LENOVO
 *
 */
public class SleepDemo02 {
	
	public static void main(String[] args) {
		//创建真实角色
		Web12306 web = new Web12306();
		//创建代理角色
		Thread t1 = new Thread(web, "张三");
		Thread t2 = new Thread(web, "李四");
		Thread t3 = new Thread(web, "王五");
		//调用start()
		t1.start();
		t2.start();
		t3.start();
	}
	
}

class Web12306 implements Runnable {

	private int num = 2;
	
	@Override
	public void run() {
		while(true) {
			if(num <= 0) {
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
		}
	}
	
}