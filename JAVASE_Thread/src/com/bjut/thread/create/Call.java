package com.bjut.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ʹ��Callable�����߳�
 * @author LENOVO
 *
 */
public class Call {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//�����߳�
		ExecutorService ser = Executors.newFixedThreadPool(2);
		Race turtle = new Race("�ڹ�", 1000);
		Race rabbit = new Race("����", 500);
		//��ȡֵ
		Future<Integer> result1 = ser.submit(turtle);
		Future<Integer> result2 = ser.submit(rabbit);
		
		Thread.sleep(2000);
		turtle.setFlag(false);
		rabbit.setFlag(false);
		
		int num1 = result1.get();
		int num2 = result2.get();
		System.out.println("�ڹ�����"+num1+"��...");
		System.out.println("��������"+num2+"��...");
		//ֹͣ����
		ser.shutdownNow();
	}
}

class Race implements Callable<Integer> {

	private String name;		//����
	private long time;			//��ʱ
	private boolean flag = true;
	private int step;
	
	public Race() {}
	
	
	public Race(String name) {
		this.name = name;
	}

	public Race(String name, long time) {
		this.name = name;
		this.time = time;
	}


	public long getTime() {
		return time;
	}


	public void setTime(long time) {
		this.time = time;
	}


	public int getStep() {
		return step;
	}


	public void setStep(int step) {
		this.step = step;
	}


	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	@Override
	public Integer call() throws Exception {
		while(flag) {
			Thread.sleep(time);	//��ʱ
			step++;
			System.out.println("==="+name+":"+step+"===");
		}
		return step;
	}
	
}