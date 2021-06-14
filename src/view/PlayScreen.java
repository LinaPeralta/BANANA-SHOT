package view;

import javax.swing.Box.Filler;

import controller.PlayController;
import excepcion.message;
import model.Monkey;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

public class PlayScreen {

	private PApplet app;
	private PImage screenOne;
	private PImage screenTwo;
	private PImage screenThree;
	private int level;
	private PlayController controller;
	private String exMessage;
	private boolean message;
	private PFont font;

	public PlayScreen(PApplet app) {
		this.app = app;
		level = 2;
		message = false;

		font = app.createFont("./data/fonts/Montserrat-Regular.otf", 20);
		
		// game screen one level 1
		screenOne = app.loadImage("./data/images/juego1.png");
		
		// game screen two level 2
		screenTwo = app.loadImage("./data/images/juego2.png");
		
		// game screen three level 3
		screenThree = app.loadImage("./data/images/juego3.png");
		
		//Controller
		controller = new PlayController(app);

	}
	
	public void levelScreens() {
		app.imageMode(PConstants.CORNER);
		
		switch (level) {
		//level1
		case 0:
			app.image(screenOne, 0, 0, 1300, 700);
			
			//Border
			if (controller.getInteraction().getMonkey().getX() < -10 && level == 0) {
				controller.getInteraction().getMonkey().setX(75);
			}
			
			if (controller.getInteraction().getMonkey().getX() > 1300 && level == 0) {
				level = 1;
				controller.getInteraction().getMonkey().setX(35);
			}

			break;
		//level2
        case 1:
        	app.image(screenTwo, 0, 0, 1300, 700);
        	
        	if (controller.getInteraction().getMonkey().getX() > 1300 && level == 1) {
				level = 2;
				controller.getInteraction().getMonkey().setX(35);
			}
        	
        	if (controller.getInteraction().getMonkey().getX() < 0 && level == 1) {
				level = 0;
				controller.getInteraction().getMonkey().setX(1280);
			}

			break;
		//level3	
        case 2:
        	app.image(screenThree, 0, 0, 1300, 700);
        	
        	//Border
			if (controller.getInteraction().getMonkey().getX() > 1200 && level == 2) {
				controller.getInteraction().getMonkey().setX(1100);
			}
        	
        	if (controller.getInteraction().getMonkey().getX() < 0 && level == 2) {
				level = 1;
				controller.getInteraction().getMonkey().setX(1280);
			}
			break;
		}
	}

	
public void drawControllerG () {
		//Condition to draw gorilla on last screen
		if (level == 2) {
			controller.drawG();
		}
}
	
	public void drawController () {
		controller.draw();
		controller.drawLevels(level);
		
		if (message) {
			app.fill(80);
			app.textFont(font);
			app.text(exMessage, 480, 70);
		}
	}

	public void monkeyMove(int movement) {
		controller.monkeyMove(movement);
	}
	
	
	public void excep () throws message {
		try {
			if (level == 1) {
				throw new message("Remember not to fall into the abyss!");
			}
			
		} catch (Exception e) {
			exMessage = e.getMessage();
			message = true;
		}
	}
	
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public PlayController getController() {
		return controller;
	}
}
