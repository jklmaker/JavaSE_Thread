package com.bjut.thread.status;

/**
 * join �ϲ��߳�
 * @author LENOVO
 *
 */
public class JoinDemo01 extends Thread {

	public static void main(String[] args) throws InterruptedException {
		JoinDemo01 demo = new JoinDemo01();
		Thread t1 = new Thread(demo);	//����
		t1.start();		//����
		//cpu��������
		
		
		for(int i=0;i<1000;i++) {
			if(i == 50)
				t1.join();		//main����
			System.out.println("main..."+i);
		}
	}
	
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("join..."+i);
		}
	}

}
