package com.bjut.thread.syn;

public class SynDemo01 {

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

	private int num = 20;
	private boolean flag = true;
	
	@Override
	public void run() {
		while(flag) {
			test5();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//线程不安全	锁定资源不正确
	private void test5() {
		synchronized((Integer)num){
			System.out.println(Thread.currentThread().getName()+"进");
			if(num <= 0) {
				flag = false;
				return;
			}
			
			System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
			System.out.println(Thread.currentThread().getName()+"出");
		}
	}
	
	//锁定范围过小
	private void test4() {
		synchronized(this){
			if(num <= 0) {
				flag = false;
				return;
			}
		}
		System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
	}
	
	//线程安全 锁定正确
	private void test3() {
		synchronized(this){
			System.out.println(Thread.currentThread().getName()+"进");
			if(num <= 0) {
				flag = false;
				return;
			}
			
			System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
			System.out.println(Thread.currentThread().getName()+"出");
		}
	}
	
	//线程安全
	private synchronized void test2() {
		if(num <= 0) {
			flag = false;
			return;
		}
		
		System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
	}
	
	//线程不安全
	private void test1() {
		if(num <= 0) {
			flag = false;
			return;
		}
		System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
	}
	
}
