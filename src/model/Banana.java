package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Banana implements Runnable{
	
	private PApplet app;
	private PImage peel;
	private int x, y, width, height, dir, damage, speed, xStarter, dist;
	private boolean visible;

	public Banana(PApplet app, int x, int y, int xStarter, int dist) {
		this.app = app;
		this.x = x;
		this.y = y;
		this.xStarter = xStarter;
		this.dist = dist;
		
		//Attributes
		width = 98;
		height = 98;
		damage = 2;
		speed = 15;
		dir = 1;
		visible = true;
		
		//Image
		//peel = app.loadImage("./data/images/banana.png");
		
	}
	
	public void draw() {
		if (visible) {
			app.imageMode(PConstants.CORNER);
			//app.image(peel, x, y, width, height);
			app.fill(0,200,0); 
			app.rect(x,y,width, height); 
		}
	}
	
	private void move() {
		x += speed*dir;

		if (x < xStarter || x > xStarter+dist) {
			dir *= (-1);
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

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	

}
