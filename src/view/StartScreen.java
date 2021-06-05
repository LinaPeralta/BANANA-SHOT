package view;

import controlP5.ControlP5;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class StartScreen {
	
	private PApplet app;
	private ControlP5 cp5;
	private PImage start;
	private PFont font;
	private boolean userBox;
	private String noFill;

	public StartScreen(PApplet app, ControlP5 cp5) {
		this.app = app;
		this.cp5 = cp5;
		
		//Image and fonts
		start = app.loadImage("./data/images/startscreen.png");
		font = app.loadFont("./data/fonts/MontserratAlternates-Regular.otf");
		
		//Variables
		userBox  = false;
		noFill = "";
		
	}
	
	public void userTextBox() {
		// TODO Auto-generated method stub

	}

}
