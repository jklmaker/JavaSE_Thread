package com.bjut.thread.syn;

/**
 * ���������ķ�ʽ
 * 1.����ʽ
 * 	������˽�л�
 * 	����˽�о�̬����
 * 	�����ṩ���ʱ����ľ�̬����,ȷ���������
 * @author LENOVO
 *
 */
public class MyJvm {

	private static MyJvm instance;
	
	private MyJvm() {}
	
	public static MyJvm getInstance() {
		if(null == instance) {	//���Ч��
			synchronized (MyJvm.class) {
				if(null == instance) {	//��֤��ȫ
					instance = new MyJvm();
				}
			}
		}
		return instance;
	} 
	
}

/**
 * ����ʽ
 * 	������˽�л�
 * 	����˽�о�̬����,��ͬʱ�����ö���
 * 	�����ṩ���ʱ����ľ�̬����
 * @author LENOVO
 *
 */
class MyJvm2 {

	private static MyJvm2 instance = new MyJvm2();
	
	private MyJvm2() {}
	
	public static MyJvm2 getInstance() {
		return instance;
	} 
	
}

/**
 * ����ʹ�õ�ʱ��ż���
 * ����ͨ���ڲ�����������ʱ��
 * @author LENOVO
 *
 */
class MyJvm3 {

	private static class JvmHolder {
		private static MyJvm3 instance = new MyJvm3();
	}
	
	private MyJvm3() {}
	
	public static MyJvm3 getInstance() {
		return JvmHolder.instance;
	} 
	
}