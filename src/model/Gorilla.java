package model;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Gorilla {
	
	private PApplet app;
	
	private PImage gorilla;
	

	private float Gbullets, addBullets, frameB;
	
	private float x, y, width, height, speedX, damage, vulnerable;
	
	private boolean dir, visible;
	
	private ArrayList<Bullet> bullets;
	
	public Gorilla(PApplet app) {
		
		this.app = app;
		
		//Image
		gorilla = app.loadImage("./data/images/gorilla.png");
				
		//Attributes
		x = 920;
		y = 88;
		width = 200;
		height = 200;
		speedX = 20;
		dir = false;
		visible = true;
		damage = 3;
	
		//Array list
		bullets = new ArrayList<>();

	}
	
	public void draw() {	
		if (visible) {
			app.imageMode(PConstants.CORNER);
			app.image(gorilla, x, y, width, height);
		}
			
		if(Gbullets>0) {
			Gbullets--;
		}
		
		//enemyBullets
		if(Gbullets == 0 && visible) {
			initShoot();
			Gbullets = 50;
		}

		//moving bullets and eliminating
		shoot();
		removeBullet();
		
	}
	
	public void initShoot() {
		int xBullet = (int) (x + 100);
		int yBullet = (int) (y + 40);
		Bullet bullet = new Bullet(app, xBullet, yBullet, dir);
		bullets.add(bullet);	
	}
	
	public void shoot() {
		for (int i = 0; i < bullets.size()  ; i++) {
			bullets.get(i).draw();
			Thread t = new Thread(bullets.get(i));
			t.start();
			if (bullets.get(i).getX() > 1300 || bullets.get(i).getX() < 0) {
				t.stop();
			}
		}
	}
	
	public void removeBullet() {
	for (int i = 0; i < bullets.size(); i++) {
			if(bullets.get(i).getX() > 1300 || bullets.get(i).getX() < 0) {
				bullets.remove(i);
			}
		}
	}
	
	public float getAddBullets() {
		return addBullets;
	}

	public void setAddBullets(float addBullets) {
		this.addBullets = addBullets;
	}

	public float getFrameB() {
		return frameB;
	}

	public void setFrameB(float frameB) {
		this.frameB = frameB;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public float getDamage() {
		return damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	public float getVulnerable() {
		return vulnerable;
	}

	public void setVulnerable(float vulnerable) {
		this.vulnerable = vulnerable;
	}

	public boolean isDir() {
		return dir;
	}

	public void setDir(boolean dir) {
		this.dir = dir;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

}
