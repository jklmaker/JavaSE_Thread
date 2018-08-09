package com.bjut.thread.status;

/**
 * join 合并线程
 * @author LENOVO
 *
 */
public class JoinDemo01 extends Thread {

	public static void main(String[] args) throws InterruptedException {
		JoinDemo01 demo = new JoinDemo01();
		Thread t1 = new Thread(demo);	//新生
		t1.start();		//就绪
		//cpu调度运行
		
		
		for(int i=0;i<1000;i++) {
			if(i == 50)
				t1.join();		//main阻塞
			System.out.println("main..."+i);
		}
	}
	
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("join..."+i);
		}
	}

}
