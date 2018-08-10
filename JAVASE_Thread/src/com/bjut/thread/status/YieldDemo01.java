package com.bjut.thread.status;

public class YieldDemo01 extends Thread{
	public static void main(String[] args) throws InterruptedException {
		YieldDemo01 demo = new YieldDemo01();
		Thread t1 = new Thread(demo);	//新生
		t1.start();		//就绪
		//cpu调度运行
		
		
		for(int i=0;i<1000;i++) {
			if(i % 20 == 0)
				yield();		//main线程暂停片刻
			System.out.println("main..."+i);
		}
	}
	
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("yield..."+i);
		}
	}
}
