package model;

import java.awt.Image;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Monkey {

	private PApplet app;
	private PImage monkeyL, monkeyR;
	private int x, y, width, height;
	private boolean dir;
	private ArrayList<Bullet> bullets;

	public Monkey(PApplet app) {
		this.app = app;
		
		//Attributes
		x = 75;
		y = 485;
		width = 200;
		height = 200;
		dir = true; //Boolean for the direction of the image
		
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
	
	public void move() {
		

	}

}
