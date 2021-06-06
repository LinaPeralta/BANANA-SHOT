package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Bullet implements Runnable{
	
	private PApplet app;
	private Monkey monkey;
	private PImage bullet;
	private int x, y, speed, damage;
	private boolean visible, dir;

	public Bullet(PApplet app, int x, int y, boolean dir) {
		this.app = app;
		this.x = x;
		this.y = y;
		this.dir = dir;
		
		//Attributes
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
			app.image(bullet, x, y, 80, 55);
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

	public int getX() {
		return x;
	}
	
}
