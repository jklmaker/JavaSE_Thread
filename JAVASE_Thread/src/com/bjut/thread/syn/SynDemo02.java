package com.bjut.thread.syn;

/**
 * �������ģʽ:ȷ��һ����ֻ��һ������
 * @author LENOVO
 *
 */
public class SynDemo02 {

	public static void main(String[] args) {
		new JvmThread(300).start();
		new JvmThread(100).start();
	}
}

class JvmThread extends Thread {

	private long millis;
	
	public JvmThread() {}
	
	public JvmThread(long millis) {
		super();
		this.millis = millis;
	}



	@Override
	public void run() {
		System.out.println(this.currentThread().getName()+"������:"+Jvm.getInstance(millis));
	}
	
}

/**
 * ȷ��һ����ֻ��һ������
 * ����ʽ	double checking
 * 1.˽�й��췽��
 * 2.����һ��˽�еľ�̬����
 * 3.����һ�����⹫����̬�������ʸñ���,����ñ���û�ж���,�����ö���
 * @author LENOVO
 *
 */
class Jvm {
	//����һ��˽�еľ�̬����
	private static Jvm instance = null;
	//˽�й��췽��
	private Jvm() {}
	
	public static Jvm getInstance(long millis) {
		//���Ч��(����Ѿ����ڶ���ķ���Ч��)
		if(null == instance) {
			synchronized (Jvm.class) {
				if(null == instance) {
					try {
						Thread.sleep(millis);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new Jvm();
				}
			}
		}
		
		return instance;
		
	}
	
	public static Jvm getInstance1(long millis) {
		//Ч�ʲ���,��Ҫ����Jvm���ֽ����ļ�	���ڶ���Ҳ��Ҫ�ȴ�
		synchronized (Jvm.class) {
			if(null == instance) {
				try {
					Thread.sleep(millis);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new Jvm();
			}
				
			return instance;
		}
	}
	
	
	public static synchronized Jvm getInstance2(long millis) {
		if(null == instance) {
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
			
		return instance;
	}
	
	public static Jvm getInstance3(long millis) {
		if(null == instance) {
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
			
		return instance;
	}
}