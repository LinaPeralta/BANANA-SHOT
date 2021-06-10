package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import processing.core.PApplet;
import processing.core.PFont;

public class Interaction {

	private PApplet app;
	private Monkey monkey;
	private Gorilla gorilla;
	private Name name;
	private String temporalName;
	//private static Interaction oneInstance;
	private ArrayList<User> users;
	private ArrayList<Banana> bananas;
	private ArrayList<Plataform> platforms;
	private Plataform goldPlatform;
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
		gorilla = new Gorilla(app);
		name = new Name();
		goldPlatform = new Plataform(app, 939, 286, 195, 50);

		// timer
		min = 0;
		seg = 0;
		time = false;
		playTime = 0;
		temporalName="";
		playTime = 0;

		//Lists
		users = new ArrayList<>();
		bananas = new ArrayList<>();
		platforms = new ArrayList<>();

		// Fonts
		font = app.createFont("./data/fonts/Montserrat-Regular.otf", 17);

		// Inits
		initBananas();
		initPlatforms();

	}

	public void draw() {
		monkey.draw();
		time = true;
		timer();
	}
	
	public void drawG() {
		gorilla.draw();
	}
	
	public void registerPlayer(String name) {
		temporalName=name;
	}

	public void addUser(String name) {
		users.add(new User(app, name));
	}
	
	public void charts(){
		
		time = false;
		
		String m= Integer.toString(min);
		String s= Integer.toString(seg);
		
		String time = m+":"+s;
		
		Date date = new Date();
	

		//String score = Integer.toString(score);
		//date = date.toString();
		
		for (int i = 0; i < users.size(); i++) {

			//users.get(i).setDate();
			users.get(i).setTime(time);
			//users.get(i).setScore(score);
		}
		
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
	}
	
	private void platformCondition(int index) {
		if (intersectPlatforms(monkey, platforms.get(index))) {
			platforms.get(index).setFill(255);
			monkey.land();
		} else {
			platforms.get(index).setFill(0);
			monkey.setConnected(false);
		}
	}
	
	//Assigning the interaction between platforms based on the level
	public void interactionPlatforms(int level) {
		switch (level) {
		case 0:
			for (int i = 0; i < 3; i++) {
				platforms.get(i).draw();
			}
			//Floor platform
			platformCondition(0);
			//platformCondition(1);
			//platformCondition(2);
			
			
			break;
		case 1:
			for (int i = 2; i < 8; i++) {
				platforms.get(i).draw();
				
	
			}
			break;
		case 2:
			for (int i = 4; i < 11; i++) {
				platforms.get(i).draw();
				
			}
			break;
		}
	}
	
	public void coinMonkey() {

	}

	public void monkeyBanana() {

	}

	public void bananaBullet() {

	}

	public void monkeyBullet() {

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
		//Platforms for level one
		//Floor
		platforms.add(new Plataform(app, 0, 675, 1300, 25));
		//Platforms
		platforms.add(new Plataform(app, 353, 427, 330, 50));
		platforms.add(new Plataform(app, 699, 267, 461, 50));
		
		//Platforms for level two
		//Floors
		platforms.add(new Plataform(app, 0, 675, 450, 25));
		platforms.add(new Plataform(app, 707, 504, 80, 196));
		platforms.add(new Plataform(app, 1011, 421, 289, 279));
		//Platforms
		platforms.add(new Plataform(app, 76, 268, 330, 50));
		platforms.add(new Plataform(app, 430, 151, 330, 50));
		
		//Platforms for level three
		//Floors
		platforms.add(new Plataform(app, 0, 421, 214, 279));
		platforms.add(new Plataform(app, 214, 675, 1086, 25));
		//Platform
		platforms.add(new Plataform(app, 434, 213, 330, 50));
		
	}
	
	public boolean intersectPlatforms(Monkey m, Plataform p) {
		//Distance apart on x axis
		float distX = (m.getX() + m.getWidth()/2) - (p.getX() + p.getWidth()/2);
		//Distance apart on y axis
		float distY = (m.getY() + m.getHeight()/2) - (p.getY() + p.getHeight()/2);
		
		float combinedW = m.getWidth()/2 + p.getWidth()/2;
		float combinedY = m.getHeight()/2 + p.getHeight()/2;
		
		//Check for intersection on x
		if (app.abs(distX) < combinedW) {
			if (app.abs(distY) < combinedY) {
				//They are intersecting
				return true;
			}
		}	
		return false;
	}

	public void monkeyMove(int movement) {
		monkey.move(movement);
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


			 app.fill(0);
			 app.textFont(font);
			 app.textSize(30);
			
			if(min<10 && seg<10) {
				
				app.text("0"+min+":00"+seg, 310, 35);
				
			}else if(min<10 && seg>10){
				
				app.text("0"+min+":"+seg, 310, 35);
				
			}else {
				
				app.text(min+":"+seg, 310, 35);

			}
			
				for (int i = 0; i < users.size(); i++) {
					users.get(i).drawData(180, 370+(50*i));
				}
			}		
		}
	}
	
	
	public void organizeName() {
		Collections.sort(users, name);
	}
		

	public Monkey getMonkey() {
		return monkey;
	}

	public void setMonkey(Monkey monkey) {
		this.monkey = monkey;
	}

}
