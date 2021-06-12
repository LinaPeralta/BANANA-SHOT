package model;

import java.awt.Image;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Monkey{

	private PApplet app;
	private PImage monkeyL, monkeyR;
	private float x, y, width, height, speedX, speedY, coolDown, vulnerable, damage;
	private boolean dir, connected;
	private ArrayList<Bullet> bullets;
	private float gravity;

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
		gravity = 4.2f;
		coolDown = 10;
		connected = false;
		damage = 1;
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
		
		//Apply gravity when not on a platform
		if (connected == false) {
			speedY = speedY + gravity; 
		}
		
		//Movement
		y += speedY;
		
		//Drawing bullets, moving bullets and eliminating
		shoot();
		eliminateBullet();
		
	}
	
	public void move(int movement) {
		switch (movement) {
		// For left movement
		case 1:
			dir = false;
			speedX = -20;
			x += speedX;
			break;
		// For right movement
		case 2:
			dir = true;
			speedX = 20;
			x += speedX;
			break;
		// For jumping
		case 3:
			speedY = -20;
			y += speedY;
			connected = false;
			break;
		// To go down
		case 4:
			speedY = 20;
			connected = true;
			break;
		//To shoot
		case 5:
			initShoot();
			break;
		}
		
		if (!(movement == 1) && !(movement == 2)) {
			speedX = 0;
		}else if (movement == 1 && movement == 2) {
			speedX = 0;
		}
		
	}
	
	public void land() {
		speedY = 0;
		connected = true;
	}
	
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

	
	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;

	}

	public float getSpeedY() {
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
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
	
	public boolean isConnected() {
		return connected;
	}
	
	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public float getVulnerable() {
		return vulnerable;
	}

	public void setVulnerable(float vulnerable) {
		this.vulnerable = vulnerable;
	}

	public float getDamage() {
		return damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}
	
	
	
}
