package model;

import java.awt.Image;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Monkey implements Runnable{

	private PApplet app;
	private PImage monkeyL, monkeyR;
	private int x, y, width, height, speedX, speedY, dirX, dirY;
	private boolean dir;
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
		dirX = 1;
		dirY = 1;
		gravity = (float) 0.6;
		
		//Images
		monkeyL = app.loadImage("./data/images/monkeyL.png");
		monkeyR = app.loadImage("./data/images/monkeyR.png");
		
		bullets = new ArrayList<>();
		
	}
	
	public void draw() {
		if (dir) {
			app.image(monkeyR, x, y, width, height);
		} else {
			app.image(monkeyL, x, y, width, height);
		}
	}
	
	public void move(char key) {
		
		switch (key) {
		//Left
		case 'a':
			dir = false;
			speedX = -20;
			break;
		//Right
		case 'd':
			dir = true;
			speedX = 20;
			break;
		//Up
		/*case 'w':
			speedY = -15;
			break;*/
		}
		
		//Gravity for jumping
		//speedY += gravity;
		
		x += speedX;
		y += speedY;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
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
	

}
