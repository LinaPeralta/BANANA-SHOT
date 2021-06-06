package controller;

import model.Interaction;
import processing.core.PApplet;

public class PlayController {
	
	private PApplet app;
	private Interaction interaction;

	public PlayController(PApplet app) {
		this.app = app;
		
		interaction = new Interaction(app);
		
	}
	
	public void draw() {
		interaction.draw();

	}
	
	public void monkeyMove(char key) {
		interaction.monkeyMove(key);

	}

}
