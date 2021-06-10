package model;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Gorilla {
	
	private PApplet app;
	
	private PImage gorilla;
	
	private int  health, bulletsG, coolDown;
	
	private int x, y, width, height, vulnerable;

	private boolean dir, visible;
	
	private ArrayList<Bullet> bullets;
	
	public Gorilla(PApplet app) {
		this.app = app;
		
		//Attributes
		x = 920;
		y = 88;
		width = 200;
		height = 200;
		bulletsG = 30;
		dir = false;
		health = 3;
		coolDown = 150;
		
		//Image
		gorilla = app.loadImage("./data/images/gorilla.png");
		
		//Arraylist
		bullets = new ArrayList<>();

	}
	
	public void draw() {		
		app.image(gorilla, x, y, width, height);
			
		if(bulletsG>0) {
			bulletsG--;
		}
		
		//enemyBullets
		if(bulletsG == 0) {
			initShoot();
			bulletsG = 30;
		}

		//Drawing bullets, moving bullets and eliminating
		shoot();
		eliminateBullet();
		
	}
	
	public void initShoot() {
		int xBullet = x+100;
		int yBullet = y+150;
		Bullet bullet = new Bullet(app, xBullet, yBullet, dir);
		bullets.add(bullet);
	}
	
	public void shoot() {
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw();
			new Thread(bullets.get(i)).start();
		}
	}
	
	public void eliminateBullet() {
		
		for (int i = 0; i < bullets.size(); i++) {
			if(bullets.get(i).getX()<0 || bullets.get(i).isVisible()==true) {
				bullets.remove(i);
			}
	}
	
}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public PImage getGorilla() {
		return gorilla;
	}

	public void setGorilla(PImage gorilla) {
		this.gorilla = gorilla;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getVulnerable() {
		return vulnerable;
	}

	public void setVulnerable(int vulnerable) {
		this.vulnerable = vulnerable;
	}

	public boolean isDir() {
		return dir;
	}

	public void setDir(boolean dir) {
		this.dir = dir;
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}


	
}
