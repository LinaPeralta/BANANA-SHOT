package view;

import controller.StartController;
import controller.StatController;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

public class StatScreen {
	
	private PApplet app;
	
	private PImage chart;
	
	private PFont font;
	
	private StatController controller;

	public StatScreen(PApplet app) {
		
		this.app = app;
		
		//Controller
		controller = new StatController(app);
		
		//Image
		chart = app.loadImage("./data/images/chart.png");
<<<<<<< HEAD
		font = app.createFont("./data/fonts/Montserrat-Refular.otf", 12);
=======
		font = app.createFont("./data/fonts/Montserrat-Regular.otf", 12);
>>>>>>> 62aaaed54748a5ecbdd93dba4f8bb77828e4cfb5
		
	}

	public void draw() {
		app.imageMode(PConstants.CORNER);
		app.image(chart, 0, 0, 1300, 700);

	}
	
	
}
