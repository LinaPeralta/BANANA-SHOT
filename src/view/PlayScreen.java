package view;


import model.Interaction;
import processing.core.PApplet;
import processing.core.PImage;

public class PlayScreen {

	private PApplet app;
	private PImage screenOne;
	private PImage screenTwo;
	private PImage screenThree;
<<<<<<< HEAD
	
	private Interaction interaction;

	public PlayScreen(PApplet app) {
		this.app = app;
		
		interaction = new Interaction (app);
=======
	private int level;

	public PlayScreen(PApplet app) {
		this.app = app;
		level = 0;
>>>>>>> 77a9fa0be64d1bb6eb5cf5a47e863b70e57fe450

		// game screen one level 1
		screenOne = app.loadImage("./data/images/juego1.png");
		
		// game screen two level 2
		screenTwo = app.loadImage("./data/images/juego2.png");
		
		// game screen three level 3
		screenThree = app.loadImage("./data/images/juego3.png");

	}

<<<<<<< HEAD
	public void drawlevel1() {

		app.image(screenOne, 0, 0, 1300, 700);
		interaction.draw();

	}
=======
>>>>>>> 77a9fa0be64d1bb6eb5cf5a47e863b70e57fe450
	
	public void levelScreens() {
		
		switch (level) {
		//level1
		case 0:
			app.image(screenOne, 0, 0, 1300, 700);
			break;
		//level2
        case 1:
        	app.image(screenTwo, 0, 0, 1300, 700);
			break;
		//level3	
        case 2:
        	app.image(screenThree, 0, 0, 1300, 700);
			break;
		}
	}
	
	
	public void drawController () {
		
		
		
		
		
		
		
		
		
		
	}

}
