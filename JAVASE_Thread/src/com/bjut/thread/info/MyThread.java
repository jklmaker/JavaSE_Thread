package com.bjut.thread.info;

public class MyThread implements Runnable {

	private boolean flag = true;
	private int num;
	
	@Override
	public void run() {
		while(flag) {
			System.out.println(Thread.currentThread().getName()+num++);
		}
	}
	
	public void stop() {
		flag = !flag;
	}

}
