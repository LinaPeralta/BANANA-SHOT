package model;

import java.awt.Image;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Monkey{

	private PApplet app;
	private PImage monkeyL, monkeyR;
	private int x, y, width, height, speedX, speedY, coolDown, vulnerable;
	private boolean dir;
	private ArrayList<Bullet> bullets;
	private float gravity;
	private boolean connected;
	private boolean up;

	public Monkey(PApplet app) {
		this.app = app;
		
		//Attributes
		x = 75;
		y = 485;
		width = 200;
		height = 200;
		dir = true; //Boolean for the direction of the image
		speedX = 0;
		speedY = 0;
		gravity = (float) 0.6;
		coolDown = 10;
		connected = false;
		up = true;
		//Images
		monkeyL = app.loadImage("./data/images/monkeyL.png");
		monkeyR = app.loadImage("./data/images/monkeyR.png");
		
		bullets = new ArrayList<>();
		
	}
	
	public void draw() {
		//Cool down for shooting bananas
		if (coolDown > 0) {
			coolDown--;
		}
		
		//Set direction in which the monkey is looking to switch image
		if (dir) {
			app.image(monkeyR, x, y, width, height);
		} else {
			app.image(monkeyL, x, y, width, height);
		}
		
		
		//Drawing bullets, moving bullets and eliminating
		shoot();
		eliminateBullet();
		
	}
	
	public void moveLeft() {
		dir = false;
		speedX = -20;
		x += speedX;
		y += speedY;
	}
	
	public void moveRight() {
		dir = true;
		speedX = 20;
		x += speedX;
		y += speedY;
	}
	
//	public void jump() {
//	//	Gravity for jumping
////		if (up) {
//		speedY = -15;
//		y += speedY;
//		//connected = false;
//		
//		//speedY += gravity;
////		}
//		
////		if (connected == false) {
////			speedY += gravity;
////		}
//		
//	}
//	
////	public void connect() {
////		if (connected == false) {
////			speedY += gravity;
////		}
////	}
//	
//
//	public void land() {
//		
//		speedY = 0;
//		//y = 485;
//		//connected = true;
//		
//	}
	
	//In key pressed to create the bullet and add it to the list
	public void initShoot() {
		if (coolDown == 0) {
			Bullet bullet = new Bullet(app, x+100, y+150, dir);
			bullets.add(bullet);
			coolDown = 10;
		}
	}

	//In draw to actually paint the bullets
	public void shoot() {
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw();
			new Thread(bullets.get(i)).start();
		}
	}
	
	//Eliminates the bullet after passing the limit of the screen (for space)
	public void eliminateBullet() {
		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).getX() > 1300 || bullets.get(i).getX() < 0) {
				bullets.remove(i);
			}
		}
	}

	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}
	
	
	

}
