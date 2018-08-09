package com.bjut.thread.create;

public class RabbitApp {

	public static void main(String[] args) {
		Rabbit rab = new Rabbit();
		Turtle tur = new Turtle();
		
		rab.start();
		tur.start();
		
		for(int i=0;i<1000;i++) {
			System.out.println("main==>"+i);
		}
	}
}
