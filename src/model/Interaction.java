package model;

import java.util.Collections;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PFont;

public class Interaction {

	private PApplet app;
	private Monkey monkey;
	//private  double gravity;
	//private User user;
	
	private Name name;
	
	private static Interaction oneInstance;
	
	private LinkedList<User> user;
	
	private PFont font;
	private int min, seg;
	private boolean time;
	//private  boolean connected;

	public Interaction(PApplet app) {

		this.app = app;

		// Classes
		monkey = new Monkey(app);

		// timer
		min = 0;
		seg = 0;
		time = false;
		//gravity = 0.6;
		//connected = false;


		font = app.createFont("./data/fonts/Montserrat-Regular.otf", 17);

		font = app.createFont("./data/fonts/Montserrat-Regular.otf", 12);

		user = new LinkedList<User>();
		
		name = new Name();

		font = app.createFont("./data/fonts/Montserrat-Regular.otf", 17);

		
	}
	
	public static Interaction getInstance(PApplet app) {
		
		if(oneInstance == null) {
			
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
		if (monkey.getX() < 345 && monkey.getY() >  430 && monkey.getX() > 677 && monkey.getY() < 477) {
		
			
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

	}

	public void initPlatforms() {

	}


	public void monkeyMove(int movement) {
		switch (movement) {
		//For left movement
		case 1:
			monkey.moveLeft();
			break;
		//For right movement
		case 2:
			monkey.moveRight();
			break;
		//For jumping
		case 3:
			//monkey.jump();
			break;
		//For shooting
		case 4:
			monkey.initShoot();
			break;
			
		//For fall
		case 5:
			//monkey.land();
			//monkey.connect();
			break;	
		}
		


	}

	

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


//		if (time==true) {	
//		
//		if (app.frameCount % 60 == 0 && min >= 0) {
//		      seg++;
//		  }
//		  if (seg == 60) {
//		      min++;
//		      seg = 0;
//		  }
//		  if (min < 0) {
//		    app.fill(0);
//		    app.textFont(font);
//		    app.textSize(30);
//		    app.text("0:00", 310, 35);
//		    
//		  } else if (seg <= 9) {
//			  
//			app.fill(0);
//			app.textFont(font);
//			app.textSize(30);
//			app.text(min + ":0" + seg, 310, 35);
//		    
//		  } else if (seg > 9) {
//			  
//			  app.fill(0);
//				app.textFont(font);
//				app.textSize(30);
//				app.text(min + ":" + seg, 310, 35);
//		    
//		  }
//	}
//
	}
	
	public void drawData() {

		for (int i = 0; i < user.size(); i++) {
			user.get(i).drawData(180, 370+(50*i));
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
