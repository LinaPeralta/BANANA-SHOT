package view;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class GameoverScreen {

	private PApplet app;
	private PImage gOver;

	public GameoverScreen(PApplet app) {
		this.app = app;
		
		// Image
		gOver = app.loadImage("./data/images/gameover.png");
	}
	
	public void draw () {
		app.imageMode(PConstants.CORNER);
		app.image(gOver, 0, 0, 1300, 700);
	}

}
