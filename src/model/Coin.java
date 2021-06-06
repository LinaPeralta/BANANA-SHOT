package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Coin {
	
	private PApplet app;
	private PImage coin;

	public Coin(PApplet app) {
		this.app = app;
		
	coin = app.loadImage("./data/images/coin.png");
		
	}
	
	
	public void draw() {
		app.image(coin, 0, 0);
		
	}
	
	

}
