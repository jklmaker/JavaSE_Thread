package com.bjut.thread.status;

public class YieldDemo01 extends Thread{
	public static void main(String[] args) throws InterruptedException {
		YieldDemo01 demo = new YieldDemo01();
		Thread t1 = new Thread(demo);	//����
		t1.start();		//����
		//cpu��������
		
		
		for(int i=0;i<1000;i++) {
			if(i % 20 == 0)
				yield();		//main�߳���ͣƬ��
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
