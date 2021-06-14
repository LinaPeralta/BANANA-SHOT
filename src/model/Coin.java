package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Coin {
	
	private PApplet app;
	private PImage coin;
	private int x,y;
	private boolean visible;

	public Coin(PApplet app,int x, int y) {
		this.app = app;
		this.x =x;
		this.y =y;
		visible = true;
		
		coin = app.loadImage("./data/images/coin.png");
		
	}
	
	
	public void draw() {
		if (visible == true) {
		app.imageMode(PConstants.CENTER);
		app.image(coin, x, y,60,60);
		}
	}


	public PImage getCoin() {
		return coin;
	}


	public void setCoin(PImage coin) {
		this.coin = coin;
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
