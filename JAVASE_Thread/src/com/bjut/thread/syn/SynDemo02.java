package com.bjut.thread.syn;

/**
 * 单例设计模式:确保一个类只有一个对象
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
		System.out.println(this.currentThread().getName()+"创建了:"+Jvm.getInstance(millis));
	}
	
}

/**
 * 确保一个类只有一个对象
 * 懒汉式	double checking
 * 1.私有构造方法
 * 2.声明一个私有的静态变量
 * 3.创建一个对外公共静态方法访问该变量,如果该变量没有对象,创建该对象
 * @author LENOVO
 *
 */
class Jvm {
	//声明一个私有的静态变量
	private static Jvm instance = null;
	//私有构造方法
	private Jvm() {}
	
	public static Jvm getInstance(long millis) {
		//提高效率(提高已经存在对象的访问效率)
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
		//效率不高,需要创建Jvm的字节码文件	存在对象也需要等待
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