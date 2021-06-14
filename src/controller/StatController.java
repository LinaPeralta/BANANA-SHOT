package controller;

import model.Interaction;
import processing.core.PApplet;
import processing.core.PFont;

public class StatController {
	
	private PApplet app;
	private Interaction interaction;

	public StatController(PApplet app) {
		
		this.app = app;
		
		interaction = new Interaction(app);
		
	}
	
	public void drawData(PFont font) {
		
		interaction.data(font);
	
	}
	
	public void sortList(char key) {
		
		interaction.sortList(key);
	
	}

}
