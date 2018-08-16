package com.bjut.thread.schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Timer()
 * 
 * schedule(TimerTask task, Date time) 
 * 		安排在指定的时间执行指定的任务。
 * schedule(TimerTask task, Date firstTime, long period) 
 * 		安排指定的任务在指定的时间开始进行重复的固定延迟执行。
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
