package model;

import java.util.Collections;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PFont;

public class Interaction {
	
	private PApplet app;
	private Monkey monkey;
	//private User user;
	
	private Name name;
	
	private static Interaction oneInstance;
	
	private LinkedList<User> user;
	
	private PFont font;
	private int min, seg,playTime ;
	private boolean time;

	public Interaction(PApplet app) {
		
		this.app = app;

		//Classes
		monkey = new Monkey(app);

		//timer
		min = 0;
		seg = 0;
		time = false;
		playTime = 0;
		
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

	public void timer() {

		if (time==true) {	
	
			playTime++;
			if(playTime %20 == 0) {
				seg++;
				playTime = 0;
			}if(seg==20) {
				seg = 0;
				min++;
			}
			 app.fill(0);
			 app.textFont(font);
			 app.textSize(30);
			
			if(min<10 && seg<10) {
				
				app.text("0"+min+":0"+seg, 310, 35);
				
			}else if(min<10 && seg>10){
				
				app.text("0"+min+":"+seg, 310, 35);
				
			}else {
				
				app.text(min+":"+seg, 310, 35);
				
			}

	}
		
		
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
	
	
}
