package com.bjut.thread.create;

public class ProgrammerApp {

	public static void main(String[] args) {
		//������ʵ��ɫ
		Programmer pro = new Programmer();
		//���������ɫ+��ʵ��ɫ����
		Thread proxy = new Thread(pro);
		//���� start()�����߳�
		proxy.start();
		
		for(int i=0;i<1000;i++) {
			System.out.println("========");
		}
	}
}
