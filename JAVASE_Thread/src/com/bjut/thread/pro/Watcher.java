package com.bjut.thread.pro;

public class Watcher implements Runnable {

	private Movie m;
	
	public Watcher(Movie m) {
		this.m = m;
	}
	
	
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			m.watch();
		}
		
	}

}
