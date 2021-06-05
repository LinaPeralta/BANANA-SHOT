package model;

import processing.core.PApplet;
import processing.core.PFont;

public class Interaction {
	
	private PApplet app;
	
	private PFont font;
	
	private int min,seg;
	private boolean time;
	
	public Interaction(PApplet app) {
		
		this.app = app;
		
		//timer
		min = 0;
		seg = 0;
		time = false;
		
		font = app.createFont("./data/fonts/Montserrat-Regular.otf", 17);
		
	}
	
	public void draw() {
		
		time = true;
		
		timer();
		
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

//	public void drawTimer() {
//
//		if (time==true) {
//
//
//			if (app.frameCount % 60 == 0) {
//				seg += 1;
//			}
//			if (seg == 60) {
//				seg = 0;
//				min += 1;
//			}
//		}
//		app.fill(255);
//		app.textFont(font);
//		app.textSize(40);
//		app.text("Time: "+ min + ":" + seg, 210, 15);
//	}

	public void timer() {

		if (time==true) {	
		
		if (app.frameCount % 60 == 0 && min >= 0) {
		      seg++;
		  }
		  if (seg == 60) {
		      min++;
		      seg = 0;
		  }
		  if (min < 0) {
		    app.fill(0);
		    app.textFont(font);
		    app.textSize(30);
		    app.text("0:00", 540, 42);
		    
		  } else if (seg <= 9) {
			  
			app.fill(0);
			app.textFont(font);
			app.textSize(30);
			app.text(min + ":0" + seg, 540, 42);
		    
		  } else if (seg > 9) {
			  
			  app.fill(0);
				app.textFont(font);
				app.textSize(30);
				app.text(min + ":" + seg, 540, 42);
		    
		  }
	}
}
	
}
