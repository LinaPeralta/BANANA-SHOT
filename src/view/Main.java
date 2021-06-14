package view;
import controlP5.ControlP5;
import excepcion.message;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{

	//Libraries
	private ControlP5 cp5;
	
	//Start screen
	private StartScreen startScreen;
	//Instruction screen
	private InstructionScreen instructions;
	//Play screen
	private PlayScreen playScreen;
	//Stat screen
	private StatScreen statScreen;
	//Game over screen
	private GameoverScreen gOver;
	
	//Variables
	private int screen;
	private boolean left, right, jump, shoot, down;
	private PImage youWin;
	
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
		startScreen = new StartScreen(this, cp5);
		
		//Instruction screen
		instructions = new InstructionScreen(this);
		
		//Play screen
		playScreen = new PlayScreen (this);
		
		//Stat screen
		statScreen = new StatScreen (this);
		
		//Game over screen
		gOver = new GameoverScreen (this);
		
		//You win image
		youWin = loadImage("./data/images/youwon.png");
		
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
		
		background(255);
		
		switch (screen) {
		//Start screen
		case 0:
			startScreen.draw();
			
			//Exception for text box
			try {
				startScreen.excep();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
		//Instructions screen
		case 1:
			instructions.draw();
			break;
		//Play screen
		case 2:
			playScreen.levelScreens();
			playScreen.drawController();
			playScreen.drawControllerG();
			keyMovements();
			
			//Exception for level 2
			try {
				playScreen.excep();
			} catch (message e) {
				e.printStackTrace();
			}
			
			//To switch to game over screen
			if (playScreen.getController().getInteraction().isGameOver()) {
				screen = 3;
			}
			
			//To switch to you win screen
			if (playScreen.getController().getInteraction().isYouWin()) {
				screen = 5;
			}
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
		case 5:
			imageMode(CORNER);
			image(youWin, 0, 0, 1300, 700);
			break;
		}	
		
	}

	@Override
	public void mousePressed() {
		
		switch (screen) {
		//Start screen
		case 0:
			//Show text when restart
			startScreen.showText();

			//If to hide text, add user and switch to the following screen
			if (mouseX > 540 && mouseX < 765 && mouseY > 580 && mouseY < 637 && startScreen.isBoxFilled()) {
				startScreen.addUser();
				startScreen.hideText();
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
			if (mouseX > 554 && mouseX < 777 && mouseY > 524 && mouseY < 580) {
				screen = 0;
			}
			
			if (mouseX > 585 && mouseX < 745 && mouseY > 605 && mouseY < 647) {
				screen = 4;
			}
				
				
			break;
		//Stat screen
		case 4:
			if(mouseX > 528 && mouseX < 771 && mouseY > 589 && mouseY < 647) {
				screen = 0;
			}
			break;
		}

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
