package com.bjut.thread.create;
/**
 * ��̬�������ģʽ
 * 1.��ʵ��ɫ
 * 2.�����ɫ:������ʵ��ɫ������
 * 3.����ʵ��ͬһ���ӿ�
 * @author LENOVO
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		//������ʵ��ɫ
		You you = new You();
		//���������ɫ
		WeddingCompany wc = new WeddingCompany(you);
		//ִ������
		wc.marry();
		
	}

}

//�ӿ�
interface Marry {
	public abstract void marry();
}
//��ʵ��ɫ
class You implements Marry {

	@Override
	public void marry() {
		
	}
	
}
//�����ɫ
class WeddingCompany implements Marry {
	private Marry you;
	
	public WeddingCompany() {
		
	}
	
	public WeddingCompany(Marry you) {
		this.you = you;
	}

	private void before() {
		
	}
	
	private void after() {
		
	}

	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}
	
}