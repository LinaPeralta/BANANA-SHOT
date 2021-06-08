package model;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Gorilla {
	
	private PApplet app;
	
	private PImage gorilla;
	
	private int x, y, width, height, speedX, speedY, coolDown, vulnerable;

	private ArrayList<Bullet> bullets;
	
	public Gorilla(PApplet app) {
		this.app = app;
		
		x = 901;
		y = 68;
		width = 200;
		height = 200;
		
		gorilla = app.loadImage("./data/images/monkeyL.png");
		
		bullets = new ArrayList<>();
		
	}
	
	public void draw() {
		
		app.image(gorilla, x, y, width, height);
		
	}

	

	
	
	
}
