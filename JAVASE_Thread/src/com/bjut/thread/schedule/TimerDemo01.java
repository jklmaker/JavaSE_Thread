package com.bjut.thread.schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Timer()
 * 
 * schedule(TimerTask task, Date time) 
 * 		������ָ����ʱ��ִ��ָ��������
 * schedule(TimerTask task, Date firstTime, long period) 
 * 		����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�
 * @author LENOVO
 *
 */
public class TimerDemo01 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("so easy...");
			}
		}, new Date(System.currentTimeMillis()+1000*5), 2000);
	}
}
