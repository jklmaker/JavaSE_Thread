package com.bjut.thread.create;

/**
 * 模拟龟兔赛跑
 * 创建多线程 继承Thread类 重写run()方法
 * 使用线程 创建子类对象,调用start()方法
 * @author LENOVO
 *
 */
public class Rabbit extends Thread{

	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("兔子跑了"+i+"步");
		}
	}

}

class Turtle extends Thread {

	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("乌龟跑了"+i+"步");
		}
	}
	
}
