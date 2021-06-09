package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Bullet implements Runnable{
	
	private PApplet app;
	private Monkey monkey;
	private PImage bullet;
	private float x, y, width, height, speed, damage;
	private boolean visible, dir;

	public Bullet(PApplet app, float x, float y, boolean dir) {
		this.app = app;
		this.x = x;
		this.y = y;
		this.dir = dir;
		
		//Attributes
		width = 80;
		height = 55;
		speed = 25;
		visible = true;
		damage = 2;
		
		//Image
		bullet = app.loadImage("./data/images/banana.png");
		
		monkey = new Monkey(app);
		
	}
	
	public void draw() {
		if (visible) {
			app.imageMode(PConstants.CENTER);
			app.image(bullet, x, y, width, height);
		}

	}
	
	private void move() {
		if (dir) {
			x += speed;
		} else {
			x -= speed;
		}

	}

	@Override
	public void run() {
		move();
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
	
}
