package view;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class StatScreen {
	
	private PApplet app;
	
	private PImage chart;
	
	private PFont font;
	

	public StatScreen(PApplet app) {
		
		this.app = app;
		
		//Image
		chart = app.loadImage("./data/images/chart.png");
		font = app.createFont("./data/fonts/MontserratAlternates-Refular.otf", 12);
		
	}

}
