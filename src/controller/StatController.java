package controller;

import model.Interaction;
import processing.core.PApplet;

public class StatController {
	
	private PApplet app;
	private Interaction interaction;

	public StatController(PApplet app) {
		
		this.app = app;
		
		interaction = Interaction.getInstance(app);
		
	}
	
	public void drawData() {
		
	interaction.drawData();
	
	}
	
	public void charts() {
		
		interaction.charts();
	}
	
	public void Names() {
		
		interaction.organizeName();
		
	}

}
