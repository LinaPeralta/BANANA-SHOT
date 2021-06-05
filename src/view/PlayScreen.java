package view;


import controller.PlayController;
import processing.core.PApplet;
import processing.core.PImage;

public class PlayScreen {

	private PApplet app;
	private PImage screenOne;
	private PImage screenTwo;
	private PImage screenThree;
<<<<<<< HEAD

	

=======
>>>>>>> c98b1a43b230866ee3d9b1f7ff9f483c8cb6b27d
	private int level;
	private PlayController controller;

	public PlayScreen(PApplet app) {
		this.app = app;
		level = 0;

		
		
		// game screen one level 1
		screenOne = app.loadImage("./data/images/juego1.png");
		
		// game screen two level 2
		screenTwo = app.loadImage("./data/images/juego2.png");
		
		// game screen three level 3
		screenThree = app.loadImage("./data/images/juego3.png");
		
		//Controller
		controller = new PlayController(app);

	}
<<<<<<< HEAD


	public void drawlevel1() {

		
		app.image(screenOne, 0, 0, 1300, 700);
		

	}

=======
>>>>>>> c98b1a43b230866ee3d9b1f7ff9f483c8cb6b27d
	
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
		controller.draw();
		
		
		
		
		
		
		
		
		
	}

}
