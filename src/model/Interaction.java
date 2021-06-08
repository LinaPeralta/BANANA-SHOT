package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PFont;

public class Interaction {

	private PApplet app;
	private Monkey monkey;

	// private double gravity;
	// private User user;

	private Name name;
	private static Interaction oneInstance;
	private LinkedList<User> user;
	private ArrayList<Banana> bananas;
	private PFont font;
	private int min, seg, playTime;
	private boolean time;
	private int x, y;
	private boolean dir;

	// private boolean connected;

	public Interaction(PApplet app) {

		this.app = app;

		// Classes
		monkey = new Monkey(app);
		name = new Name();
		

		// timer
		min = 0;
		seg = 0;
		time = false;

		// gravity = 0.6;
		// connected = false;

		font = app.createFont("./data/fonts/Montserrat-Regular.otf", 17);

		font = app.createFont("./data/fonts/Montserrat-Regular.otf", 12);

		playTime = 0;

		// Lists

		user = new LinkedList<User>();
		bananas = new ArrayList<>();

		// Fonts
		font = app.createFont("./data/fonts/Montserrat-Regular.otf", 17);

		// Inits
		initBananas();

		System.out.println(bananas.size());

	}

	public static Interaction getInstance(PApplet app) {

		if (oneInstance == null) {

			oneInstance = new Interaction(app);

		}

		return oneInstance;

	}

	public void draw() {
		monkey.draw();
		time = true;

		timer();

		// drawTimer();

	}

	// Draw and move bananas based on the level they're on
	public void drawBananas(int level) {
		switch (level) {
		case 0:
			for (int i = 0; i < 2; i++) {
				bananas.get(i).draw();
				new Thread(bananas.get(i)).start();
			}
			break;
		case 1:
			for (int i = 2; i < 4; i++) {
				bananas.get(i).draw();
				new Thread(bananas.get(i)).start();
			}
			break;
		case 2:
			for (int i = 4; i < 6; i++) {
				bananas.get(i).draw();
				new Thread(bananas.get(i)).start();
			}
			break;
		}
		
		removeBananas();
		System.out.println(bananas.size());
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

		// if(mouseX>x1 && mouseX<x2 && mouseY>y1 && mouseY<y2)

		if (app.mouseX > 354 && app.mouseX < 677 && app.mouseY > 430 && app.mouseY < 477) {
			System.out.println("holaaaa");
		}

//		// first platform
		if (monkey.getX() < 345 && monkey.getY() > 430 && monkey.getX() > 677 && monkey.getY() < 477) {

		}
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

		// Bananas for level one
		bananas.add(new Banana(app, 682, 588, 682, 400));
		bananas.add(new Banana(app, 700, 201, 700, 400));

		// Bananas for level two
		bananas.add(new Banana(app, 160, 588, 160, 280));
		bananas.add(new Banana(app, 1011, 323, 1011, 225));

		// Bananas for level three
		bananas.add(new Banana(app, 425, 148, 425, 285));
		bananas.add(new Banana(app, 688, 588, 688, 400));

	}

	public void removeBananas() {

		for (int i = 0; i < bananas.size(); i++) {
			
			for (int j = 0; j < monkey.getBullets().size(); j++) {
				
				if (app.dist(monkey.getBullets().get(j).getX(),monkey.getBullets().get(j).getY(), bananas.get(i).getX(), bananas.get(i).getY()) < 60) {
					bananas.get(i).setVisible(false);
				//	bananas.remove(i);
					
					
				}
				
			}
		}

	}

	public void initPlatforms() {

	}

	public void monkeyMove(int movement) {
		switch (movement) {
		// For left movement
		case 1:
			monkey.moveLeft();
			break;
		// For right movement
		case 2:
			monkey.moveRight();
			break;
		// For jumping
		case 3:
			// monkey.jump();
			break;
		// For shooting
		case 4:
			monkey.initShoot();
			break;

		// For fall
		case 5:
			// monkey.land();
			// monkey.connect();
			break;
		}

	}

	public void timer() {

		if (time == true) {

			playTime++;
			if (playTime % 20 == 0) {
				seg++;
				playTime = 0;
			}
			if (seg == 20) {
				seg = 0;
				min++;
			}
			app.fill(0);
			app.textFont(font);
			app.textSize(30);

			if (min < 10 && seg < 10) {

				app.text("0" + min + ":0" + seg, 310, 35);

			} else if (min < 10 && seg > 10) {

				app.text("0" + min + ":" + seg, 310, 35);

			} else {

				app.text(min + ":" + seg, 310, 35);

			}

		}

	}

	public void drawData() {

		for (int i = 0; i < user.size(); i++) {
			user.get(i).drawData(180, 370 + (50 * i));
		}
	}

	public LinkedList<User> getUser() {
		return user;
	}

	public void setUser(LinkedList<User> user) {
		this.user = user;
	}

	public void organizeName() {

		Collections.sort(user, name);

	}

	public Monkey getMonkey() {
		return monkey;
	}

	public void setMonkey(Monkey monkey) {
		this.monkey = monkey;
	}

}
