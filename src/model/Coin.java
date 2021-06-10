package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Coin {
	
	private PApplet app;
	private PImage coin;
	private int x,y;

	public Coin(PApplet app,int x, int y) {
		this.app = app;
		this.x =x;
		this.y =y;
	coin = app.loadImage("./data/images/coin.png");
		
	}
	
	
	public void draw() {
		
		app.imageMode(PConstants.CENTER);
		app.image(coin, 0, 0);
		
	}
	
	

}
