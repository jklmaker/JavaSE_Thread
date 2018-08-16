package com.bjut.thread.pro;

public class App {

	public static void main(String[] args) {
		//共同资源
		Movie m = new Movie();
		
		//多线程
		Player p = new Player(m);
		Watcher w = new Watcher(m);
		
		new Thread(p).start();
		new Thread(w).start();
	}
}
