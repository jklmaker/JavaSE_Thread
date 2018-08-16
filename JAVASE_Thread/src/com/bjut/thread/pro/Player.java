package com.bjut.thread.pro;

public class Player implements Runnable {

	private Movie m;
	
	public Player(Movie m) {
		this.m = m;
	}



	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			if(0 == i%2) {
				m.play("×óÇàÁú");
			} else {
				m.play("ÓÒ°×»¢");
			}
		}
	}

}
