package com.bjut.thread.create;

/**
 * ģ���������
 * �������߳� �̳�Thread�� ��дrun()����
 * ʹ���߳� �����������,����start()����
 * @author LENOVO
 *
 */
public class Rabbit extends Thread{

	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("��������"+i+"��");
		}
	}

}

class Turtle extends Thread {

	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("�ڹ�����"+i+"��");
		}
	}
	
}
