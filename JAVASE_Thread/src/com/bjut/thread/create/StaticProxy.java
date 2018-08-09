package com.bjut.thread.create;
/**
 * 静态代理设计模式
 * 1.真实角色
 * 2.代理角色:持有真实角色的引用
 * 3.二者实现同一个接口
 * @author LENOVO
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		//创建真实角色
		You you = new You();
		//创建代理角色
		WeddingCompany wc = new WeddingCompany(you);
		//执行任务
		wc.marry();
		
	}

}

//接口
interface Marry {
	public abstract void marry();
}
//真实角色
class You implements Marry {

	@Override
	public void marry() {
		
	}
	
}
//代理角色
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