package com.bjut.thread.create;
/**
 * ʹ��Runnable�������߳�
 * 1.��ʵ��Runnerble�ӿ� ��дrun() ===>��ʵ��ɫ��
 * 2.�������߳� ʹ�þ�̬����
 * 	1)������ʵ��ɫ
 * 	2)���������ɫ+��ʵ��ɫ����
 * 	3)���� start()�����߳�
 * @author LENOVO
 *
 */
public class Programmer implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("HelloWorld");
		}
	}

}
