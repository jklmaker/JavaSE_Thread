package com.bjut.thread.pro;

/**
 * 一个场景,共同资源
 * 生产者消费者模式:信号灯法
 * wait()等待:释放锁	sleep()不释放锁
 * notify()/notifyall()唤醒
 * @author LENOVO
 *
 */
public class Movie {

	private String pic;
	//flag为true --->生产者生产,消费者等待(wait),生产完成后唤醒消费者(notify)
	//flag为false--->消费者消费,生产者等待,消费完成后唤醒生产者
	private boolean flag = true;
	
	/**
	 * 播放
	 * @param pic
	 */
	public synchronized void play(String pic) {
		if(!flag) {		//生产者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.pic = pic;
		System.out.println("生产了:"+this.pic);
		
		flag = false;
		this.notifyAll();		//通知消费
	}
	
	public synchronized void watch() {
		if(flag) {		//消费者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("观看了:"+pic);
		flag = true;
		this.notifyAll();		//通知生产
	}
}
