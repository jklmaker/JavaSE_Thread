package com.bjut.thread.pro;

/**
 * һ������,��ͬ��Դ
 * ������������ģʽ:�źŵƷ�
 * wait()�ȴ�:�ͷ���	sleep()���ͷ���
 * notify()/notifyall()����
 * @author LENOVO
 *
 */
public class Movie {

	private String pic;
	//flagΪtrue --->����������,�����ߵȴ�(wait),������ɺ���������(notify)
	//flagΪfalse--->����������,�����ߵȴ�,������ɺ���������
	private boolean flag = true;
	
	/**
	 * ����
	 * @param pic
	 */
	public synchronized void play(String pic) {
		if(!flag) {		//�����ߵȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.pic = pic;
		System.out.println("������:"+this.pic);
		
		flag = false;
		this.notifyAll();		//֪ͨ����
	}
	
	public synchronized void watch() {
		if(flag) {		//�����ߵȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("�ۿ���:"+pic);
		flag = true;
		this.notifyAll();		//֪ͨ����
	}
}
