package com.bjut.thread.syn;

public class SynDemo01 {

	public static void main(String[] args) {
		//������ʵ��ɫ
		Web12306 web = new Web12306();
		//���������ɫ
		Thread t1 = new Thread(web, "����");
		Thread t2 = new Thread(web, "����");
		Thread t3 = new Thread(web, "����");
		//����start()
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
	
	//�̲߳���ȫ	������Դ����ȷ
	private void test5() {
		synchronized((Integer)num){
			System.out.println(Thread.currentThread().getName()+"��");
			if(num <= 0) {
				flag = false;
				return;
			}
			
			System.out.println(Thread.currentThread().getName()+"������"+num--);
			System.out.println(Thread.currentThread().getName()+"��");
		}
	}
	
	//������Χ��С
	private void test4() {
		synchronized(this){
			if(num <= 0) {
				flag = false;
				return;
			}
		}
		System.out.println(Thread.currentThread().getName()+"������"+num--);
	}
	
	//�̰߳�ȫ ������ȷ
	private void test3() {
		synchronized(this){
			System.out.println(Thread.currentThread().getName()+"��");
			if(num <= 0) {
				flag = false;
				return;
			}
			
			System.out.println(Thread.currentThread().getName()+"������"+num--);
			System.out.println(Thread.currentThread().getName()+"��");
		}
	}
	
	//�̰߳�ȫ
	private synchronized void test2() {
		if(num <= 0) {
			flag = false;
			return;
		}
		
		System.out.println(Thread.currentThread().getName()+"������"+num--);
	}
	
	//�̲߳���ȫ
	private void test1() {
		if(num <= 0) {
			flag = false;
			return;
		}
		System.out.println(Thread.currentThread().getName()+"������"+num--);
	}
	
}
