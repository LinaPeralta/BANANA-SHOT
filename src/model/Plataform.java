package model;

import processing.core.PApplet;

public class Plataform {
	
	private PApplet app;
	private int x, y, width, height, fill;

	public Plataform(PApplet app, int x, int y, int width, int height) {
		this.app = app;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.fill = 0;
		
	}
	
	public void draw() {
		app.fill(fill);
		app.rect(x, y, width, height);

	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setFill(int fill) {
		this.fill = fill;
	}
	
	
	

}
