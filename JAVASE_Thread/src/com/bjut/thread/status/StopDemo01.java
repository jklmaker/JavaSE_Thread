package com.bjut.thread.status;

public class StopDemo01 {

	public static void main(String[] args) {
		Study s = new Study();
		new Thread(s).start();
		
		//外部干涉
		for(int i=0;i<100;i++) {
			if(50 == i) {
				s.stop();
			}
			System.out.println("main......"+i);
		}
	}
}

//线程的外部中止
class Study implements Runnable {
	//1)线程类中定义线程体使用的标识
	private boolean flag = true;
	
	@Override
	public void run() {
		//2)线程体使用该标识
		while(flag) {
			System.out.println("study thread......");
		}
	}
	//3)对外提供方法改变标识
	public void stop() {
		this.flag = false;
	}
}