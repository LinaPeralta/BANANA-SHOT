package view;

import processing.core.PApplet;
import processing.core.PImage;

public class PlayScreen {

	private PApplet app;
	private PImage screenOne;
	private PImage screenTwo;
	private PImage screenThree;

	public PlayScreen(PApplet app) {
		this.app = app;

		// game screen one level 1
		screenOne = app.loadImage("./data/images/juego1.jpg");
		
		// game screen two level 2
		screenOne = app.loadImage("./data/images/juego1.jpg");
		
		// game screen three level 3
		screenOne = app.loadImage("./data/images/juego1.jpg");

	}

	public void drawlevel1() {

		app.image(screenOne, 0, 0, 1300, 700);

	}
	
	public void drawlevel2() {

		app.image(screenTwo, 0, 0, 1300, 700);

	}
	
	public void drawlevel3() {

		app.image(screenThree, 0, 0, 1300, 700);

	}

}
