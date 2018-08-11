package com.bjut.thread.info;
/**
 * Thread.currentThread()	��ȡ��ǰ�߳�
 * setName()				��������
 * getName()				��ȡ����
 * isAlive()				�ж�״̬
 * @author LENOVO
 *
 */
public class InfoDemo01 {

	public static void main(String[] args) throws InterruptedException {
		MyThread mt = new MyThread();
		Thread proxy = new Thread(mt);
		proxy.setName("����");
		System.out.println(proxy.getName());
		System.out.println(Thread.currentThread().getName());	//���main
		
		proxy.start();
		
		System.out.println("�������״̬:"+proxy.isAlive());	//true
		Thread.sleep(100);
		mt.stop();
		Thread.sleep(100);
		System.out.println("ֹͣ���״̬:"+proxy.isAlive());	//false
	}
}
