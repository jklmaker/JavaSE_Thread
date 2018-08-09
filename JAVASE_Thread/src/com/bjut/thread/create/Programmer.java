package com.bjut.thread.create;
/**
 * 使用Runnable创建多线程
 * 1.类实现Runnerble接口 重写run() ===>真实角色类
 * 2.启动多线程 使用静态代理
 * 	1)创建真实角色
 * 	2)创建代理角色+真实角色引用
 * 	3)调用 start()启动线程
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
