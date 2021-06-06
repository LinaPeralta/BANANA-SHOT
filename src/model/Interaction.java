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

		// Classes
		monkey = new Monkey(app);

		// timer
		min = 0;
		seg = 0;
		time = false;

		font = app.createFont("./data/fonts/Montserrat-Regular.otf", 17);

		font = app.createFont("./data/fonts/Montserrat-Regular.otf", 12);

	}

	public void draw() {
		monkey.draw();
		time = true;

		timer();

		// drawTimer();

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
		
		//if(mouseX>x1 && mouseX<x2 && mouseY>y1 && mouseY<y2)

		
		if(app.mouseX>354 && app.mouseX< 677 && app.mouseY> 430 && app.mouseY< 477){
			System.out.println("holaaaa");
		}
		
//		// first platform
//		if (monkey.getX() < 345 && monkey.getY() >  430 && monkey.getX() > 677 && monkey.getY() < 477) {
//			// moverAr1N1 = false;
//		}
//		
//		if (app.mouseX < 345 && app.mouseY >  430 && app.mouseX > 677 && app.mouseY < 477) {
//			System.out.println("holaaaa");
//		}
//
//		// second platform
//		if (monkey.getX() < 1030 && monkey.getY() > 260 && monkey.getX() > 840 && monkey.getY() < 430) {
//			// moverAr1N1 = false;
//		}

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

		if (time == true) {

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
