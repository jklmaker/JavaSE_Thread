package com.bjut.thread.info;

/**
 * �߳����ȼ�:(������Ǹ���,û���Ⱥ�˳��,���Ǿ��Ե�)
 * 	MAX_PRIORITY	10
 * 	NORM_PRIORITY	5(Ĭ��)
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
		Thread t1 = new Thread(mt1, "����");
		
		MyThread mt2 = new MyThread();
		Thread t2 = new Thread(mt2, "����");
		
		t1.setPriority(Thread.MIN_PRIORITY);	//�������ȼ�
		t2.setPriority(Thread.MAX_PRIORITY);	//�������ȼ�
		
		
		t1.start();
		t2.start();
		
		Thread.sleep(100);
		mt1.stop();
		mt2.stop();
	}
}
