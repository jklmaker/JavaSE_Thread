package com.bjut.thread.syn;

/**
 * 过多的同步可能会造成死锁
 * @author LENOVO
 *
 */
public class SynDemo03 {

	public static void main(String[] args) {
		Object g = new Object();
		Object m = new Object();
		Test t1 = new Test(g,m);
		Test2 t2 = new Test2(g,m);
		Thread proxy1 = new Thread(t1);
		Thread proxy2 = new Thread(t2);
		proxy1.start();
		proxy2.start();
	}
}

class Test implements Runnable{
	Object goods = new Object();
	Object money = new Object();
	
	
	
	public Test(Object goods, Object money) {
		this.goods = goods;
		this.money = money;
	}

	@Override
	public void run() {
		while(true) {
			test();
		}
	}
	
	public void test() {
		synchronized (goods) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized (money) {
				
			}
			
		}
		System.out.println("一手给钱");
	}
}


class Test2 implements Runnable{
	Object goods;
	Object money;
	
	
	
	public Test2(Object goods, Object money) {
		this.goods = goods;
		this.money = money;
	}

	@Override
	public void run() {
		while(true) {
			test();
		}
	}
	
	public void test() {
		synchronized (money) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized (goods) {
				
			}
			
		}
		System.out.println("一手给货");
	}
}
