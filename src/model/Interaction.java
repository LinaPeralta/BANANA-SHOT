package model;

import processing.core.PApplet;
import processing.core.PFont;

public class Interaction {
	
	private PApplet app;
	private Monkey monkey;
	private PFont font;
	private int min, seg;
	private boolean time;

	public Interaction(PApplet app) {
		
		this.app = app;

		//Classes
		monkey = new Monkey(app);

		//timer
		min = 0;
		seg = 0;
		time = false;
		
		font = app.createFont("./data/fonts/Montserrat-Regular.otf", 12);
		
	}
	
	public void draw() {
		monkey.draw();
		time = true;
		drawTimer();

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

	public void drawTimer() {

		if (time==true) {


			if (app.frameCount % 60 == 0) {
				seg += 1;
			}
			if (seg == 60) {
				seg = 0;
				min += 1;
			}
		}
		app.fill(255);
		app.textFont(font);
		app.textSize(40);
		app.text("Time: "+ min + ":" + seg, 210, 15);
	}

	
}
