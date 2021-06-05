package model;

import processing.core.PApplet;

public class Interaction {
	
	private PApplet app;
	private Monkey monkey;

	public Interaction(PApplet app) {
		this.app = app;
		
		//Classes
		monkey = new Monkey(app);
	}
	
	public void draw() {
		monkey.draw();

	}
	
	public void coinMonkey() {
		


	}
	
	public void monkeyBanana() {
		
		
	}
	
	public void bananaBullet() {
		
		

	}
	
	public void monkeyBullet() {
		

	}
	
	public void gorillaBullet() {
		

	}
	
	public void platforms() {
		
		
	}
	
	public void initCoins() {
		

	}
	
	public void removeCoins() {
		

	}
	
	public void initCoinsGrabbed() {
		

	}
	
	public void initBananas() {
		

	}
	
	public void initPlatforms() {
		

	}
	
	public void monkeyMove() {
		

	}

}
