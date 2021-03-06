package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import processing.core.PApplet;
import processing.core.PFont;

public class Interaction {

	private PApplet app;
	
	//classes
	private Monkey monkey;
	private Gorilla gorilla;
	private Plataform goldPlatform;
	private UserDate userDate;
	private UserScore userScore;
	private UserTime userTime;
	
	//strings
	private String datePlayer, scorePlayer;
	
	//arrays
	private ArrayList<User> users;
	private ArrayList<Banana> bananas;
	private ArrayList<Coin> coins;
	private ArrayList<Plataform> platforms;
	
	//booleans
	private boolean time;
	private boolean gameOver, youWin;
	
	//ints
	private int min, seg, playTime, vulnerable, life, lifeG, vulnerableG, score;
	
	private PFont font;

	public Interaction(PApplet app) {

		this.app = app;

		// Classes
		monkey = new Monkey(app);
		gorilla = new Gorilla(app);
		userDate = new UserDate();
		userScore = new UserScore();
		userTime = new UserTime();
		
		// coins = new Coin(app,)
		goldPlatform = new Plataform(980, 286, 120, 5);
		
		//Attributes
		min = 0;
		seg = 0;
		time = false;
		playTime = 0;
		score = 0;
		playTime = 0;
		gameOver = false;
		youWin = false;
		vulnerable = 0;
		life = 5;
		lifeG = 3;
		vulnerable = 0;
		vulnerableG = 0;
		
		//Lists
		users = new ArrayList<>();
		bananas = new ArrayList<>();
		platforms = new ArrayList<>();
		coins = new ArrayList<>();

		// Fonts
		font = app.createFont("./data/fonts/Montserrat-Regular.otf", 17);

		//Inits
		initBananas();
		initCoins();
		initPlatforms();

	}

	public void draw() {
		monkey.draw();
		time = true;
		
		if (vulnerable > 0) {
			vulnerable--;
		}
		
		if (vulnerableG > 0) {
			vulnerableG--;
		}
		
		timer();
		score();
		lifes();

		monkeyGorilla();
		monkeyBanana();
		
		//Game finished
		gameOver();	

	}

	public void drawG() {
		gorilla.draw();
	}

	public void addUser(String name) {
		users.add(new User(app, name));
	}

	public void charts() {

		time = false;

		String m = Integer.toString(min);
		String s = Integer.toString(seg);

		String time = m + ":" + s;
		
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		datePlayer = simpleDateFormat.format(new Date());
	
		scorePlayer = Integer.toString(score);

		for (int i = 0; i < users.size(); i++) {
			users.get(i).setDate(datePlayer);
			users.get(i).setTime(time);
			users.get(i).setScore(scorePlayer);
		}

	}

	// Draw and move bananas based on the level they're on
	public void drawBananas(int level) {
		switch (level) {
		case 0:
			for (int i = 0; i < 2; i++) {
				bananas.get(i).draw();
				new Thread(bananas.get(i)).start();

				//Take life from monkey on this level
				if (app.dist(monkey.getX(), monkey.getY() + 100, bananas.get(i).getX(), bananas.get(i).getY()) < 60 &&	
						bananas.get(i).isVisible()) {
					if (vulnerable == 0) {
						life -= 1;
						vulnerable = 60;
					}
				}
			}
			break;
		case 1:
			for (int i = 2; i < 4; i++) {
				bananas.get(i).draw();
				new Thread(bananas.get(i)).start();
				
				//Take life from monkey on this level
				if (app.dist(monkey.getX(), monkey.getY() + 100, bananas.get(i).getX(), bananas.get(i).getY()) < 60 &&	
						bananas.get(i).isVisible()) {
					if (vulnerable == 0) {
						life -= 1;
						vulnerable = 60;
					}
				}
			}
			break;
		case 2:
			for (int i = 4; i < 6; i++) {
				bananas.get(i).draw();
				new Thread(bananas.get(i)).start();
				
				//Take life from monkey on this level
				if (app.dist(monkey.getX(), monkey.getY() + 100, bananas.get(i).getX(), bananas.get(i).getY()) < 60 &&	
						bananas.get(i).isVisible()) {
					if (vulnerable == 0) {
						life -= 1;
						vulnerable = 60;
					}
				}
			}
			break;
		}
		removeBananas();
	}
	
	private void setYMonkey(int index) {
		if (intersectPlatforms(monkey, platforms.get(index))) {
			monkey.setY(platforms.get(index).getY()-(monkey.getHeight()-10));
		}
	}

	// Assigning the interaction between platforms based on the level
	public void interactionPlatforms(int level) {
		switch (level) {
		case 0:
			//Platforms for level 1
				if (intersectPlatforms(monkey, platforms.get(0)) || (intersectPlatforms(monkey, platforms.get(1))
						|| (intersectPlatforms(monkey, platforms.get(2))))) {
					monkey.land();
					
					//Specifically so that the monkey doesn't land in the middle of the platform 
					setYMonkey(0);
					setYMonkey(1);
					setYMonkey(2);
					
				} else {
					monkey.setConnected(false);
				}
			break;
		case 1:
			//Platforms for level 2
			if (intersectPlatforms(monkey, platforms.get(3)) || intersectPlatforms(monkey, platforms.get(4))
					|| intersectPlatforms(monkey, platforms.get(5)) || intersectPlatforms(monkey, platforms.get(6))
					|| intersectPlatforms(monkey, platforms.get(7))) {
				monkey.land();
				
				//Specifically so that the monkey doesn't land in the middle of the platform 
				setYMonkey(3);
				setYMonkey(4);
				setYMonkey(5);
				setYMonkey(6);
				setYMonkey(7);
				
				
			} else {
				
				monkey.setConnected(false);

			}
			break;
		case 2:
			//Platforms for level 3
			if (intersectPlatforms(monkey, platforms.get(8)) || intersectPlatforms(monkey, platforms.get(9))
					|| intersectPlatforms(monkey, platforms.get(10)) || intersectPlatforms(monkey, goldPlatform)) {
				monkey.land();
				
				//Specifically so that the monkey doesn't land in the middle of the platform 
				setYMonkey(8);
				setYMonkey(9);
				setYMonkey(10);
				
				if (intersectPlatforms(monkey, goldPlatform) && lifeG == 0) {
					monkey.setY(goldPlatform.getY()-(monkey.getHeight()-10));
					youWin = true;
					charts();
				}
				
			} else {
				monkey.setConnected(false);
			}
			break;
		}
	}
		

	public void coinMonkey(int level) {
		//Draw coins
		switch (level) {
		case 0:
			for (int i = 0; i < 2; i++) {
				coins.get(i).draw();
				
				if (app.dist(monkey.getX()+50, monkey.getY()+150, coins.get(i).getX(), coins.get(i).getY()) < 60 && coins.get(i).isVisible()) {
				    coins.get(i).setVisible(false);
					score += 10;
				}
			}
			break;
		case 1:
			for (int i = 2; i < 7; i++) {
				coins.get(i).draw();
				
				if (app.dist(monkey.getX()+50, monkey.getY()+150, coins.get(i).getX(), coins.get(i).getY()) < 60 && coins.get(i).isVisible()) {
				    coins.get(i).setVisible(false);
					score += 10;
				}
			}
			break;
		case 2:
			for (int i = 7; i < 8; i++) {
				coins.get(i).draw();
				
				if (app.dist(monkey.getX()+50, monkey.getY()+150, coins.get(i).getX(), coins.get(i).getY()) < 60 && coins.get(i).isVisible()) {
				    coins.get(i).setVisible(false);
					score += 10;
				}
			}
			break;
		}

	}

	//Takes away monkeys life from gorilla bullets
	public void monkeyBanana() {
	
		for (int i = 0; i < gorilla.getBullets().size(); i++) {
			for (int j = 0; j < monkey.getBullets().size(); j++) {
				
			if (app.dist(gorilla.getBullets().get(i).getX(), gorilla.getBullets().get(i).getY(), monkey.getX(), monkey.getY()) < 100 &&
					gorilla.getBullets().get(i).isVisible()) {
				gorilla.getBullets().get(i).setVisible(false);
				if (vulnerable == 0) {
					life -= 1;
					vulnerable = 20;
				}
				
				if (lifeG == 0) {
					gorilla.setVisible(false);
					score += 30;
					monkey.getBullets().get(j).setVisible(false);
					}
				}
			}
		}
	}

	//Takes away gorilla life from monkey bullets
	public void monkeyGorilla() {
		for (int i = 0; i < monkey.getBullets().size(); i++) {
			for (int j = 0; j < gorilla.getBullets().size(); j++) {
				
			if (app.dist(monkey.getBullets().get(i).getX(), monkey.getBullets().get(i).getY(), gorilla.getX(), gorilla.getY()+50) < 100 &&
					monkey.getBullets().get(i).isVisible()) {
				monkey.getBullets().get(i).setVisible(false);
				if (vulnerableG == 0) {
					lifeG -= 1;
					vulnerableG = 20;
				}
				
				if (lifeG == 0) {
					gorilla.setVisible(false);
					score += 30;
					gorilla.getBullets().get(j).setVisible(false);
					}
				}
			}
		}
	}

	public void initCoins() {
		// coins level 1
		coins.add(new Coin(app, 397, 369));
		coins.add(new Coin(app, 570,  369));

		// coins level 2
		coins.add(new Coin(app, 104, 212));
		coins.add(new Coin(app, 206, 212));
		coins.add(new Coin(app, 315, 212));
		coins.add(new Coin(app, 502, 99));
		coins.add(new Coin(app, 725, 419));

		// coins level 3
		coins.add(new Coin(app, 39, 345));
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
				if (app.dist(monkey.getBullets().get(j).getX(), monkey.getBullets().get(j).getY(),bananas.get(i).getX(), bananas.get(i).getY()) < 60 && bananas.get(i).isVisible()) {
					bananas.get(i).setVisible(false);
					monkey.getBullets().get(j).setVisible(false);
					score += 5;
			}
		}
	}
}

	public void initPlatforms() {
		// Platforms for level one
		// Floor
		platforms.add(new Plataform(0, 675, 1300, 25));
		// Platforms
		platforms.add(new Plataform(420, 427, 130, 5));
		platforms.add(new Plataform(830, 267, 200, 5));

		// Platforms for level two
		// Floors
		platforms.add(new Plataform(0, 675, 450, 25));
		platforms.add(new Plataform(707, 504, 80, 10));
		platforms.add(new Plataform(1110, 421, 240, 10));
		// Platforms
		platforms.add(new Plataform(100, 268, 150, 5));
		platforms.add(new Plataform(550, 151, 80, 5));

		// Platforms for level three
		// Floors
		platforms.add(new Plataform(0, 421, 214, 279));
		platforms.add(new Plataform(214, 675, 1086, 25));
		// Platform
		platforms.add(new Plataform(500, 213, 220, 5));

	}

	public boolean intersectPlatforms(Monkey m, Plataform p) {
		// Distance apart on x axis
		float distX = (m.getX() + m.getWidth() / 2) - (p.getX() + p.getWidth() / 2);
		// Distance apart on y axis
		float distY = (m.getY() + m.getHeight() / 2) - (p.getY() + p.getHeight() / 2);

		float combinedW = m.getWidth() / 2 + p.getWidth() / 2;
		float combinedY = m.getHeight() / 2 + p.getHeight() / 2;

		// Check for intersection on x
		if (app.abs(distX) < combinedW) {
			
			if (app.abs(distY) < combinedY) {
				
				// They are intersecting
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

				if (min < 10 && seg < 10) {

					app.text("0" + min + ":00" + seg, 310, 35);

				} else if (min < 10 && seg > 10) {

					app.text("0" + min + ":" + seg, 310, 35);

				} else {

					app.text(min + ":" + seg, 310, 35);

				}
			}
		}
	}
	
	public void data(PFont font) {
		
		int yTemp = 210; 
		
		for (int i = 0; i < users.size(); i++) {
			users.get(i).drawData(yTemp + (i*35), font);
		}
		
	}

	public void score() {
		app.fill(0);
		app.textFont(font);
		app.textSize(30);
		app.text("Score: " + score, 700, 35);
	}

	public void lifes() {
		app.fill(0);
		app.textFont(font);
		app.textSize(30);
		app.text("Life: " + life, 1000, 35);
	}
	
	public void gameOver() {
		if (life == 0) {
			gameOver = true;
			charts();
		}
		
		if (monkey.getY() > 700) {
			gameOver = true;
			charts();
		}
	}
	
	public void sortList(char key) {
		
		switch (key) {
		case 'h':
			
			Collections.sort(users);
			
			break;
		case 'j':
		
			Collections.sort(users, userDate);
		
			break;
		case 'k':
			
			Collections.sort(users, userScore);
		
			break;
		case 'l':
		
			Collections.sort(users, userTime);
			
			break;
		}
		
	}

	public Monkey getMonkey() {
		return monkey;
	}

	public void setMonkey(Monkey monkey) {
		this.monkey = monkey;
	}

	public boolean isGameOver() {
		return gameOver;
	}
	
	public boolean isYouWin() {
		return youWin;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
}
