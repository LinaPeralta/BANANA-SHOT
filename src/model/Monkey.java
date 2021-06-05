package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Monkey {

	private PApplet app;
	private PImage monkeyL, monkeyR;

	public Monkey(PApplet app) {
		this.app = app;
		
		//Images
		monkeyL = app.loadImage("./data/images/monkeyL.png");
		monkeyR = app.loadImage("./data/images/monkeyR.png");
		
	}

}
