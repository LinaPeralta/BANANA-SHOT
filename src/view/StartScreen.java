package view;

import controlP5.ControlP5;
import controlP5.Textfield;
import controller.StartController;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

public class StartScreen {
	
	private PApplet app;
	private ControlP5 cp5;
	private PImage start;
	private PFont font;
	private StartController controller;
	private boolean userBox, boxFilled;
	private String noFill;

	public StartScreen(PApplet app, ControlP5 cp5) {
		this.app = app;
		this.cp5 = cp5;
		
		//Image and fonts
		start = app.loadImage("./data/images/startscreen.png");
		font = app.createFont("./data/fonts/Montserrat-Regular.otf", 20);
		
		//Variables
		userBox  = true;
		boxFilled = false;
		noFill = "";
		
		//Controller
		controller = new StartController();
		
		userTextBox();
		
	}
	
	public void userTextBox() {
		cp5.addTextfield("username")
		.setPosition(485, 505)
		.setSize(335, 35)
		.setFont(font)
		.setAutoClear(true)
		.setColor(80)
		.setColorActive(app.color(255, 0, 0, 1))
		.setColorBackground(app.color(255, 255, 255, 1))
		.setColorForeground(app.color(255, 0, 0, 1))
		.getCaptionLabel()
		.hide();
	}
	
	public void fillConfirmation() {
		//Makes sure that the textfield is filled before allowing the user to continue
		userBox = (!noFill.equals(cp5.get(Textfield.class, "username").getText()));
		
		if (userBox) {
			boxFilled = true;
		}
	}
	
	public void draw() {
		//Background for the start screen
		app.imageMode(PConstants.CORNER);
		app.image(start, 0, 0, 1300, 700);
		
		fillConfirmation();

	}
	
	public void hideText() {
		//Hides and clears the textfield for following screens
		cp5.get(Textfield.class, "username").hide();
		cp5.get(Textfield.class, "username").clear();
	}
	
	public void showText() {
		//Shows text when on the first screen again
		cp5.get(Textfield.class, "username").show();
	}
	
	public void addUser() {
		//controller.addUser(cp5.get(Textfield.class, "username").getText());
	}
	
	public boolean isBoxFilled() {
		return boxFilled;
	}

}
