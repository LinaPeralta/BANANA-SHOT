package view;
import controlP5.ControlP5;

import model.Interaction;

import model.Monkey;

import processing.core.PApplet;

public class Main extends PApplet{

	//Libraries
	private ControlP5 cp5;
	
	//Start screen
	private StartScreen start;
	//Instruction screen
	private InstructionScreen instructions;
	//Play screen
	private PlayScreen playScreen;
	//Stat screen
	private StatScreen statScreen;
	//Game over screen
	private GameoverScreen gOver;
	private Interaction interaction;
	
	//Variables
	private int screen;
	private boolean left, right, jump, shoot, down;
	
	
	public static void main(String[] args) {
		PApplet.main("view.Main");
	}
		
	
	@Override
	public void settings() {
		size(1300, 700);
	}
	
	@Override
	public void setup() {
		
		//Library
		cp5 = new ControlP5(this);
		
		//Start screen
		start = new StartScreen(this, cp5);
		
		//Instruction screen
		instructions = new InstructionScreen(this);
		
		//Play screen
		playScreen = new PlayScreen (this);
		
		//Stat screen
		statScreen = new StatScreen (this);
		
		//Game over screen
		gOver = new GameoverScreen (this);
		interaction = new Interaction (this);
		
		
		
		//Variables
		screen = 2;
		left = false;
		right = false;
		shoot = false;
		jump = false;
		down = false;
	}
	
	@Override
	public void draw() {
		
		//System.out.println(mouseX+","+mouseY);
		
		background(255);
		
		switch (screen) {
		//Start screen
		case 0:
			start.draw();
			break;
		//Instructions screen
		case 1:
			instructions.draw();
			break;
		//Play screen
		case 2:
			playScreen.levelScreens();
			playScreen.drawController();
			keyMovements();
			break;
		//Game over screen
		case 3:
			gOver.draw();
	
			break;
		//Stat screen
		case 4:
			
			statScreen.draw();
			statScreen.charts();
			break;
		}	
		
	}
	
	@Override
	public void mousePressed() {
		
		switch (screen) {
		//Start screen
		case 0:
			//Show text when restart
			start.showText();
			//If to hide text, add user and switch to the following screen
			if (mouseX > 540 && mouseX < 765 && mouseY > 580 && mouseY < 637 && start.isBoxFilled()) {
				start.addUser();
				start.hideText();
				screen = 1;
			}
			
			
			
			
			
			
			
			break;
		//Instructions screen
		case 1:
			if (mouseX > 530 && mouseX < 775 && mouseY > 590 && mouseY < 650) {
				screen = 2;
			}
			
			
			
			
			
			
			
			
			
			break;
		//Play screen
		case 2:

			
			
			
			
			
			
			
			break;
		//Game over screen
		case 3:
	
			
			
			
			
			
			
			
			break;
		//Stat screen
		case 4:
			
			
			if(mouseX > 528 && mouseX < 771 && mouseY > 589 && mouseY < 647) {
				
				screen = 0;
				
			}
			
			
			
			
			
			break;
		}
		
	System.out.println(mouseX + "," + mouseY);

	}

	@Override
	public void keyPressed() {
		if (screen == 2) {
			switch (key) {
			case 'a':
				left = true;
				break;
			case 'd':
				right = true;
				break;
			case 'w':
				jump = true;
				break;
			case ' ':
				shoot = true;
				break;
			case 's':
				down = true;
				break;
			}
		}
	}
	
	@Override
	public void keyReleased() {
		if (screen == 2) {
			switch (key) {
			case 'a':
				left = false;
				break;
			case 'd':
				right = false;
				break;
			case 'w':
				jump = false;
				break;
			case 's':
				down = false;
				break;
			}
		}
	}
	
	//Allows smoother movements 
	private void keyMovements() {
		
		if (left) {
			playScreen.monkeyMove(1);
		}
		
		if (right) {
			playScreen.monkeyMove(2);
		}
		
		if (jump) {
			playScreen.monkeyMove(3);
		}
		
		if (down) {
			playScreen.monkeyMove(4);
		}
		
		if (shoot) {
			playScreen.monkeyMove(5);
			shoot = false;
		}

	}

	
}
