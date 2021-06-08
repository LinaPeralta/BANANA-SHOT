package controller;

import java.util.ArrayList;

import model.Interaction;
import model.User;
import processing.core.PApplet;

public class StartController {

	private PApplet app;
	private Interaction interaction;

	public StartController(PApplet app) {
		
		this.app = app;
		
		interaction = new Interaction(app);
		
	}
	
	public void addUser(String name) {
		
		interaction.addUser(name);

	}
	

	
	

}
